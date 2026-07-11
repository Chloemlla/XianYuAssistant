package com.feijimiao.xianyuassistant.service.impl;

import com.feijimiao.xianyuassistant.cache.CacheService;
import com.feijimiao.xianyuassistant.entity.SysLoginToken;
import com.feijimiao.xianyuassistant.entity.SysUser;
import com.feijimiao.xianyuassistant.entity.SysRefreshToken;
import com.feijimiao.xianyuassistant.mapper.SysLoginTokenMapper;
import com.feijimiao.xianyuassistant.mapper.SysRefreshTokenMapper;
import com.feijimiao.xianyuassistant.mapper.SysUserMapper;
import com.feijimiao.xianyuassistant.persistence.MongoQueryWrapper;
import com.feijimiao.xianyuassistant.service.AuthService;
import com.feijimiao.xianyuassistant.service.bo.*;
import com.feijimiao.xianyuassistant.util.JwtUtil;
import com.feijimiao.xianyuassistant.security.BootstrapInitializationGuard;
import com.feijimiao.xianyuassistant.security.BootstrapAuthorizationException;
import com.feijimiao.xianyuassistant.security.AlreadyInitializedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/**
 * 认证服务实现
 * @author IAMLZY
 * @date 2026/4/22
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /** 登录错误限制：10分钟内最多5次 */
    private static final int MAX_LOGIN_ATTEMPTS = 5;
    private static final long LOGIN_ATTEMPT_WINDOW_MS = 10 * 60 * 1000L;

    /** 缓存key前缀 */
    private static final String LOGIN_ATTEMPT_PREFIX = "login_attempt:";

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysLoginTokenMapper sysLoginTokenMapper;

    @Autowired
    private SysRefreshTokenMapper sysRefreshTokenMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private BootstrapInitializationGuard bootstrapInitializationGuard;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Value("${security.bootstrap-token:}")
    private String bootstrapToken;

    @Value("${jwt.refresh-expiration:604800000}")
    private long refreshExpirationMs;

    private final SecureRandom secureRandom = new SecureRandom();

    @Override
    public CheckUserExistsRespBO checkUserExists() {
        CheckUserExistsRespBO respBO = new CheckUserExistsRespBO();
        long count = sysUserMapper.selectCount(null);
        respBO.setExists(count > 0);
        return respBO;
    }

    @Override
    public synchronized LoginRespBO register(RegisterReqBO reqBO) {
        // 检查是否已有用户
        long count = sysUserMapper.selectCount(null);
        if (count > 0) {
            throw new AlreadyInitializedException("已有账号，无法注册");
        }
        validateBootstrapToken(reqBO.getBootstrapToken());
        String bootstrapOwner = bootstrapInitializationGuard.acquire();
        boolean bootstrapFinalized = false;
        try {
            if (sysUserMapper.selectCount(null) > 0) {
                throw new AlreadyInitializedException("已有账号，无法注册");
            }

        // 检查用户名是否重复
        MongoQueryWrapper<SysUser> wrapper = new MongoQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, reqBO.getUsername());
        SysUser existing = sysUserMapper.selectOne(wrapper);
        if (existing != null) {
            throw new RuntimeException("用户名已存在");
        }

        // 创建用户
        SysUser user = new SysUser();
        user.setUsername(reqBO.getUsername());
        user.setPassword(passwordEncoder.encode(reqBO.getPassword()));
        user.setStatus(1);
        user.setCreatedTime(LocalDateTime.now().format(FORMATTER));
        user.setUpdatedTime(LocalDateTime.now().format(FORMATTER));
        sysUserMapper.insert(user);
        bootstrapInitializationGuard.complete(bootstrapOwner);
        bootstrapFinalized = true;

        log.info("[Auth] 注册成功: username={}", reqBO.getUsername());

        // 注册后自动登录
        LoginReqBO loginReqBO = new LoginReqBO();
        loginReqBO.setUsername(reqBO.getUsername());
        loginReqBO.setPassword(reqBO.getPassword());
            LoginRespBO response = login(loginReqBO);
            return response;
        } catch (RuntimeException e) {
            if (!bootstrapFinalized) {
                bootstrapInitializationGuard.release(bootstrapOwner);
            }
            throw e;
        }
    }

    @Override
    public LoginRespBO login(LoginReqBO reqBO) {
        // 查找用户
        MongoQueryWrapper<SysUser> wrapper = new MongoQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, reqBO.getUsername());
        SysUser user = sysUserMapper.selectOne(wrapper);

        if (user == null) {
            throw new RuntimeException("用户名或密码错误");
        }

        if (user.getStatus() != null && user.getStatus() == 0) {
            throw new RuntimeException("账号已被禁用");
        }

        // 验证密码
        if (!passwordEncoder.matches(reqBO.getPassword(), user.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }

        // 生成Token
        String token = jwtUtil.generateToken(user.getId(), user.getUsername());

        // 单设备登录：删除该用户之前的所有Token（挤下线旧设备）
        MongoQueryWrapper<SysLoginToken> tokenWrapper = new MongoQueryWrapper<>();
        tokenWrapper.eq(SysLoginToken::getUserId, user.getId());
        sysLoginTokenMapper.delete(tokenWrapper);
        MongoQueryWrapper<SysRefreshToken> refreshWrapper = new MongoQueryWrapper<>();
        refreshWrapper.eq(SysRefreshToken::getUserId, user.getId());
        sysRefreshTokenMapper.delete(refreshWrapper);

        // 保存新Token到数据库
        SysLoginToken loginToken = new SysLoginToken();
        loginToken.setUserId(user.getId());
        loginToken.setToken(token);
        loginToken.setDeviceId(reqBO.getDeviceId());
        loginToken.setLoginIp(reqBO.getIp());
        long expirationMs = jwtUtil.getExpiration();
        loginToken.setExpireTime(LocalDateTime.now().plusNanos(expirationMs * 1_000_000L).format(FORMATTER));
        loginToken.setCreatedTime(LocalDateTime.now().format(FORMATTER));
        loginToken.setUpdatedTime(LocalDateTime.now().format(FORMATTER));
        sysLoginTokenMapper.insert(loginToken);

        // 更新用户最后登录信息
        user.setLastLoginTime(LocalDateTime.now().format(FORMATTER));
        user.setLastLoginIp(reqBO.getIp());
        sysUserMapper.updateById(user);

        // 缓存Token（提高性能）
        cacheService.put("token:" + token, user.getId(), expirationMs, TimeUnit.MILLISECONDS);

        log.info("[Auth] 登录成功: username={}, ip={}", reqBO.getUsername(), reqBO.getIp());

        LoginRespBO respBO = new LoginRespBO();
        respBO.setToken(token);
        respBO.setUsername(user.getUsername());
        respBO.setRefreshToken(issueRefreshToken(user.getId()));
        return respBO;
    }

    @Override
    public synchronized LoginRespBO refresh(String refreshToken) {
        String tokenHash = hashRefreshToken(refreshToken);
        MongoQueryWrapper<SysRefreshToken> wrapper = new MongoQueryWrapper<>();
        wrapper.eq(SysRefreshToken::getTokenHash, tokenHash);
        SysRefreshToken stored = sysRefreshTokenMapper.selectOne(wrapper);
        if (stored == null) {
            throw new SecurityException("refresh token无效");
        }
        LocalDateTime expiresAt = LocalDateTime.parse(stored.getExpireTime(), FORMATTER);
        if (!expiresAt.isAfter(LocalDateTime.now())) {
            sysRefreshTokenMapper.deleteById(stored.getId());
            throw new SecurityException("refresh token已过期");
        }
        SysUser user = sysUserMapper.selectById(stored.getUserId());
        if (user == null || Integer.valueOf(0).equals(user.getStatus())) {
            sysRefreshTokenMapper.deleteById(stored.getId());
            throw new SecurityException("用户不可用");
        }
        sysRefreshTokenMapper.deleteById(stored.getId());
        revokeAccessTokens(user.getId());

        String accessToken = jwtUtil.generateToken(user.getId(), user.getUsername());
        saveAccessToken(user, accessToken, null, null);
        LoginRespBO response = new LoginRespBO();
        response.setToken(accessToken);
        response.setRefreshToken(issueRefreshToken(user.getId()));
        response.setUsername(user.getUsername());
        return response;
    }

    @Override
    public boolean isTokenValid(String token) {
        // 先查缓存
        Object cached = cacheService.get("token:" + token);
        if (cached != null) {
            return true;
        }

        // 缓存未命中，查数据库
        MongoQueryWrapper<SysLoginToken> wrapper = new MongoQueryWrapper<>();
        wrapper.eq(SysLoginToken::getToken, token);
        SysLoginToken loginToken = sysLoginTokenMapper.selectOne(wrapper);

        if (loginToken == null) {
            return false;
        }

        // 检查是否过期
        try {
            LocalDateTime expireTime = LocalDateTime.parse(loginToken.getExpireTime(), FORMATTER);
            if (expireTime.isBefore(LocalDateTime.now())) {
                // Token已过期，删除
                sysLoginTokenMapper.deleteById(loginToken.getId());
                return false;
            }
        } catch (Exception e) {
            log.warn("[Auth] 解析Token过期时间失败: {}", loginToken.getExpireTime());
        }

        // 回填缓存
        long remainingMs = Math.max(1, java.time.Duration.between(LocalDateTime.now(),
                LocalDateTime.parse(loginToken.getExpireTime(), FORMATTER)).toMillis());
        cacheService.put("token:" + token, loginToken.getUserId(), remainingMs, TimeUnit.MILLISECONDS);
        return true;
    }

    @Override
    public boolean checkLoginAttempt(String ip) {
        String key = LOGIN_ATTEMPT_PREFIX + ip;
        Object count = cacheService.get(key);
        if (count == null) {
            return true;
        }
        if (count instanceof Number) {
            return ((Number) count).intValue() < MAX_LOGIN_ATTEMPTS;
        }
        // AtomicLong类型
        try {
            long val = Long.parseLong(count.toString());
            return val < MAX_LOGIN_ATTEMPTS;
        } catch (Exception e) {
            return true;
        }
    }

    @Override
    public void recordLoginFailure(String ip) {
        String key = LOGIN_ATTEMPT_PREFIX + ip;
        if (!cacheService.containsKey(key)) {
            // 首次失败，设置10分钟过期
            cacheService.put(key, cacheService.increment(key), LOGIN_ATTEMPT_WINDOW_MS, TimeUnit.MILLISECONDS);
        } else {
            cacheService.increment(key);
            // 确保过期时间存在
            if (cacheService.getExpire(key) == -1) {
                cacheService.expire(key, LOGIN_ATTEMPT_WINDOW_MS, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override
    public void clearLoginFailure(String ip) {
        String key = LOGIN_ATTEMPT_PREFIX + ip;
        cacheService.remove(key);
    }

    @Override
    public SysUser getCurrentUser(Long userId) {
        return sysUserMapper.selectById(userId);
    }

    @Override
    public void changePassword(ChangePasswordReqBO reqBO) {
        SysUser user = sysUserMapper.selectById(reqBO.getUserId());
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!passwordEncoder.matches(reqBO.getOldPassword(), user.getPassword())) {
            throw new RuntimeException("原密码错误");
        }
        user.setPassword(passwordEncoder.encode(reqBO.getNewPassword()));
        user.setUpdatedTime(LocalDateTime.now().format(FORMATTER));
        sysUserMapper.updateById(user);
        revokeUserTokens(user.getId());
        log.info("[Auth] 修改密码成功: userId={}", reqBO.getUserId());
    }

    @Override
    public void logout(String token) {
        if (token == null || token.isEmpty()) {
            return;
        }

        // 删除数据库中的Token
        MongoQueryWrapper<SysLoginToken> wrapper = new MongoQueryWrapper<>();
        wrapper.eq(SysLoginToken::getToken, token);
        SysLoginToken existing = sysLoginTokenMapper.selectOne(wrapper);
        sysLoginTokenMapper.delete(wrapper);

        // 删除缓存中的Token
        cacheService.remove("token:" + token);
        if (existing != null) {
            MongoQueryWrapper<SysRefreshToken> refreshWrapper = new MongoQueryWrapper<>();
            refreshWrapper.eq(SysRefreshToken::getUserId, existing.getUserId());
            sysRefreshTokenMapper.delete(refreshWrapper);
        }

        log.info("[Auth] 退出登录成功");
    }

    private void validateBootstrapToken(String suppliedToken) {
        if (bootstrapToken == null || bootstrapToken.length() < 24) {
            throw new BootstrapAuthorizationException("BOOTSTRAP_TOKEN must be configured with at least 24 characters before first registration");
        }
        byte[] expected = bootstrapToken.getBytes(StandardCharsets.UTF_8);
        byte[] actual = suppliedToken == null ? new byte[0] : suppliedToken.getBytes(StandardCharsets.UTF_8);
        if (!MessageDigest.isEqual(expected, actual)) {
            throw new BootstrapAuthorizationException("首次注册需要有效的部署初始化令牌");
        }
    }

    private void revokeUserTokens(Long userId) {
        revokeAccessTokens(userId);
        MongoQueryWrapper<SysRefreshToken> refreshWrapper = new MongoQueryWrapper<>();
        refreshWrapper.eq(SysRefreshToken::getUserId, userId);
        sysRefreshTokenMapper.delete(refreshWrapper);
    }

    private void revokeAccessTokens(Long userId) {
        MongoQueryWrapper<SysLoginToken> wrapper = new MongoQueryWrapper<>();
        wrapper.eq(SysLoginToken::getUserId, userId);
        List<SysLoginToken> tokens = sysLoginTokenMapper.selectList(wrapper);
        for (SysLoginToken token : tokens) {
            if (token.getToken() != null) {
                cacheService.remove("token:" + token.getToken());
            }
        }
        sysLoginTokenMapper.delete(wrapper);
    }

    private String issueRefreshToken(Long userId) {
        byte[] random = new byte[32];
        secureRandom.nextBytes(random);
        String plainToken = Base64.getUrlEncoder().withoutPadding().encodeToString(random);
        SysRefreshToken refreshToken = new SysRefreshToken();
        refreshToken.setUserId(userId);
        refreshToken.setTokenHash(hashRefreshToken(plainToken));
        refreshToken.setCreatedTime(LocalDateTime.now().format(FORMATTER));
        refreshToken.setExpireTime(LocalDateTime.now().plusNanos(refreshExpirationMs * 1_000_000L).format(FORMATTER));
        sysRefreshTokenMapper.insert(refreshToken);
        return plainToken;
    }

    private String hashRefreshToken(String plainToken) {
        if (plainToken == null || plainToken.isBlank()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(plainToken.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
        } catch (Exception e) {
            throw new IllegalStateException("无法计算refresh token摘要", e);
        }
    }

    private void saveAccessToken(SysUser user, String token, String deviceId, String loginIp) {
        long expirationMs = jwtUtil.getExpiration();
        SysLoginToken loginToken = new SysLoginToken();
        loginToken.setUserId(user.getId());
        loginToken.setToken(token);
        loginToken.setDeviceId(deviceId);
        loginToken.setLoginIp(loginIp);
        loginToken.setExpireTime(LocalDateTime.now().plusNanos(expirationMs * 1_000_000L).format(FORMATTER));
        loginToken.setCreatedTime(LocalDateTime.now().format(FORMATTER));
        loginToken.setUpdatedTime(LocalDateTime.now().format(FORMATTER));
        sysLoginTokenMapper.insert(loginToken);
        cacheService.put("token:" + token, user.getId(), expirationMs, TimeUnit.MILLISECONDS);
    }
}
