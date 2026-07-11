package com.feijimiao.xianyuassistant.service.impl;

import com.feijimiao.xianyuassistant.cache.CacheService;
import com.feijimiao.xianyuassistant.entity.SysRefreshToken;
import com.feijimiao.xianyuassistant.entity.SysUser;
import com.feijimiao.xianyuassistant.mapper.SysLoginTokenMapper;
import com.feijimiao.xianyuassistant.mapper.SysRefreshTokenMapper;
import com.feijimiao.xianyuassistant.mapper.SysUserMapper;
import com.feijimiao.xianyuassistant.service.bo.LoginRespBO;
import com.feijimiao.xianyuassistant.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuthServiceImplRefreshTest {
    @Test
    void refreshTokenIsHashedRotatedAndOldAccessSessionsRevoked() throws Exception {
        String plainRefresh = "refresh-token-sentinel";
        SysRefreshToken stored = new SysRefreshToken();
        stored.setId(1L);
        stored.setUserId(7L);
        stored.setTokenHash(Base64.getUrlEncoder().withoutPadding().encodeToString(
                MessageDigest.getInstance("SHA-256").digest(plainRefresh.getBytes(StandardCharsets.UTF_8))));
        stored.setExpireTime(LocalDateTime.now().plusHours(1)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));

        SysUser user = new SysUser();
        user.setId(7L);
        user.setUsername("admin");
        user.setStatus(1);

        SysRefreshTokenMapper refreshMapper = mock(SysRefreshTokenMapper.class);
        SysLoginTokenMapper loginMapper = mock(SysLoginTokenMapper.class);
        SysUserMapper userMapper = mock(SysUserMapper.class);
        JwtUtil jwtUtil = mock(JwtUtil.class);
        when(refreshMapper.selectOne(any())).thenReturn(stored);
        when(loginMapper.selectList(any())).thenReturn(List.of());
        when(userMapper.selectById(7L)).thenReturn(user);
        when(jwtUtil.generateToken(7L, "admin")).thenReturn("new-access-token");
        when(jwtUtil.getExpiration()).thenReturn(900_000L);

        AuthServiceImpl service = new AuthServiceImpl();
        ReflectionTestUtils.setField(service, "sysRefreshTokenMapper", refreshMapper);
        ReflectionTestUtils.setField(service, "sysLoginTokenMapper", loginMapper);
        ReflectionTestUtils.setField(service, "sysUserMapper", userMapper);
        ReflectionTestUtils.setField(service, "jwtUtil", jwtUtil);
        ReflectionTestUtils.setField(service, "cacheService", mock(CacheService.class));
        ReflectionTestUtils.setField(service, "refreshExpirationMs", 604_800_000L);

        LoginRespBO response = service.refresh(plainRefresh);
        assertEquals("new-access-token", response.getToken());
        assertNotEquals(plainRefresh, response.getRefreshToken());
        verify(refreshMapper).deleteById(1L);
        verify(refreshMapper).insert(any(SysRefreshToken.class));
        verify(loginMapper).delete(any());
    }
}
