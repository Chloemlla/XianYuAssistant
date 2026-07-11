<script setup lang="ts">
import { ref, onMounted, nextTick } from 'vue'
import { checkUserExists, login, register } from '@/api/auth'
import { setAuthToken, isLoggedIn } from '@/utils/request'

// 'checking' -> 'login' -> 'register'
const mode = ref<'checking' | 'login' | 'register'>('checking')
const loading = ref(false)

const username = ref('')
const password = ref('')
const confirmPassword = ref('')
const bootstrapToken = ref('')

const showPassword = ref(false)
const showConfirmPassword = ref(false)
const formError = ref('')
const usernameError = ref('')
const passwordError = ref('')
const confirmPasswordError = ref('')
const bootstrapTokenError = ref('')
const usernameInput = ref<HTMLInputElement | null>(null)
const passwordInput = ref<HTMLInputElement | null>(null)
const confirmPasswordInput = ref<HTMLInputElement | null>(null)
const bootstrapTokenInput = ref<HTMLInputElement | null>(null)

const clearErrors = () => {
  formError.value = ''
  usernameError.value = ''
  passwordError.value = ''
  confirmPasswordError.value = ''
  bootstrapTokenError.value = ''
}

const focusFirstError = async () => {
  await nextTick()
  if (usernameError.value) usernameInput.value?.focus()
  else if (passwordError.value) passwordInput.value?.focus()
  else if (confirmPasswordError.value) confirmPasswordInput.value?.focus()
  else if (bootstrapTokenError.value) bootstrapTokenInput.value?.focus()
}

onMounted(async () => {
  // 已登录则跳转首页
  if (isLoggedIn()) {
    window.location.href = '/dashboard'
    return
  }
  // 检查是否有用户，决定显示登录还是注册
  try {
    const res = await checkUserExists()
    if (res.code === 200 && res.data) {
      // exists=true -> 有用户 -> 登录; exists=false -> 无用户 -> 注册
      mode.value = res.data.exists ? 'login' : 'register'
    } else {
      mode.value = 'login'
      formError.value = res.msg || '无法确认系统初始化状态，请尝试登录'
    }
  } catch {
    mode.value = 'login'
    formError.value = '无法连接服务器，请检查服务状态后重试'
  }
})

async function handleLogin() {
  clearErrors()
  if (!username.value.trim()) usernameError.value = '请输入账号'
  if (!password.value) passwordError.value = '请输入密码'
  if (usernameError.value || passwordError.value) {
    await focusFirstError()
    return
  }
  loading.value = true
  try {
    const res = await login({ username: username.value.trim(), password: password.value })
    if (res.code === 200 && res.data && res.data.token && res.data.refreshToken) {
      setAuthToken(res.data.token, res.data.refreshToken, res.data.username)
      window.location.href = '/dashboard'
    } else {
      formError.value = res.msg || '账号或密码错误'
    }
  } catch (e) {
    formError.value = e instanceof Error ? e.message : '登录失败，请稍后重试'
  } finally {
    loading.value = false
  }
}

async function handleRegister() {
  clearErrors()
  const normalizedUsername = username.value.trim()
  if (!normalizedUsername) usernameError.value = '请输入账号'
  else if (normalizedUsername.length < 3) usernameError.value = '账号至少需要 3 个字符'
  if (!password.value) passwordError.value = '请输入密码'
  else if (password.value.length < 6) passwordError.value = '密码至少需要 6 个字符'
  if (!confirmPassword.value) confirmPasswordError.value = '请再次输入密码'
  else if (password.value !== confirmPassword.value) confirmPasswordError.value = '两次输入的密码不一致'
  if (!bootstrapToken.value.trim()) bootstrapTokenError.value = '请输入部署初始化令牌'
  if (usernameError.value || passwordError.value || confirmPasswordError.value || bootstrapTokenError.value) {
    await focusFirstError()
    return
  }
  loading.value = true
  try {
    const res = await register({
      username: normalizedUsername,
      password: password.value,
      confirmPassword: confirmPassword.value,
      bootstrapToken: bootstrapToken.value.trim()
    })
    if (res.code === 200 && res.data && res.data.token && res.data.refreshToken) {
      setAuthToken(res.data.token, res.data.refreshToken, res.data.username)
      window.location.href = '/dashboard'
    } else {
      formError.value = res.msg || '创建账号失败'
    }
  } catch (e) {
    formError.value = e instanceof Error ? e.message : '创建账号失败，请稍后重试'
  } finally {
    loading.value = false
  }
}

function handleKeydown(e: KeyboardEvent) {
  if (e.key === 'Enter' && !loading.value) {
    if (mode.value === 'login') handleLogin()
    else if (mode.value === 'register') handleRegister()
  }
}
</script>

<template>
  <div class="login-page">
    <div class="login-card">
      <!-- Logo -->
      <div class="login-logo">
        <div class="login-logo-icon">闲</div>
        <div class="login-logo-text">XianYuAssistant</div>
      </div>

      <!-- Loading -->
      <div v-if="mode === 'checking'" class="login-loading">
        <div class="login-spinner"></div>
      </div>

      <!-- Login Form -->
      <div v-else-if="mode === 'login'" class="login-form">
        <h2 class="login-title">登录</h2>
        <p class="login-subtitle">请输入账号密码登录</p>

        <div v-if="formError" class="login-form-error" role="alert" aria-live="assertive">{{ formError }}</div>

        <div class="login-field">
          <label class="login-label" for="login-username">账号</label>
          <div class="login-input-wrap">
            <input
              id="login-username"
              ref="usernameInput"
              v-model="username"
              type="text"
              class="login-input"
              placeholder="请输入账号"
              autocomplete="username"
              :disabled="loading"
              :aria-invalid="!!usernameError"
              aria-describedby="login-username-error"
              @keydown="handleKeydown"
            />
          </div>
          <p v-if="usernameError" id="login-username-error" class="login-field-error">{{ usernameError }}</p>
        </div>

        <div class="login-field">
          <label class="login-label" for="login-password">密码</label>
          <div class="login-input-wrap">
            <input
              id="login-password"
              ref="passwordInput"
              v-model="password"
              :type="showPassword ? 'text' : 'password'"
              class="login-input"
              placeholder="请输入密码"
              autocomplete="current-password"
              :disabled="loading"
              :aria-invalid="!!passwordError"
              aria-describedby="login-password-error"
              @keydown="handleKeydown"
            />
            <button type="button" class="login-eye-btn" :aria-label="showPassword ? '隐藏密码' : '显示密码'" @click="showPassword = !showPassword">
              {{ showPassword ? '隐藏' : '显示' }}
            </button>
          </div>
          <p v-if="passwordError" id="login-password-error" class="login-field-error">{{ passwordError }}</p>
        </div>

        <button class="login-btn" :disabled="loading" @click="handleLogin">
          <span v-if="loading" class="login-btn-spinner"></span>
          {{ loading ? '请稍候...' : '登录' }}
        </button>
      </div>

      <!-- Register Form -->
      <div v-else-if="mode === 'register'" class="login-form">
        <h2 class="login-title">创建账号</h2>
        <p class="login-subtitle">首次使用，请创建管理员账号</p>

        <div v-if="formError" class="login-form-error" role="alert" aria-live="assertive">{{ formError }}</div>

        <div class="login-field">
          <label class="login-label" for="register-username">账号</label>
          <div class="login-input-wrap">
            <input
              id="register-username"
              ref="usernameInput"
              v-model="username"
              type="text"
              class="login-input"
              placeholder="请输入账号"
              autocomplete="username"
              :disabled="loading"
              :aria-invalid="!!usernameError"
              aria-describedby="register-username-error"
              @keydown="handleKeydown"
            />
          </div>
          <p v-if="usernameError" id="register-username-error" class="login-field-error">{{ usernameError }}</p>
        </div>

        <div class="login-field">
          <label class="login-label" for="register-password">密码</label>
          <div class="login-input-wrap">
            <input
              id="register-password"
              ref="passwordInput"
              v-model="password"
              :type="showPassword ? 'text' : 'password'"
              class="login-input"
              placeholder="请输入密码"
              autocomplete="new-password"
              :disabled="loading"
              :aria-invalid="!!passwordError"
              aria-describedby="register-password-error"
              @keydown="handleKeydown"
            />
            <button type="button" class="login-eye-btn" :aria-label="showPassword ? '隐藏密码' : '显示密码'" @click="showPassword = !showPassword">
              {{ showPassword ? '隐藏' : '显示' }}
            </button>
          </div>
          <p v-if="passwordError" id="register-password-error" class="login-field-error">{{ passwordError }}</p>
        </div>

        <div class="login-field">
          <label class="login-label" for="register-confirm-password">确认密码</label>
          <div class="login-input-wrap">
            <input
              id="register-confirm-password"
              ref="confirmPasswordInput"
              v-model="confirmPassword"
              :type="showConfirmPassword ? 'text' : 'password'"
              class="login-input"
              placeholder="请再次输入密码"
              autocomplete="new-password"
              :disabled="loading"
              :aria-invalid="!!confirmPasswordError"
              aria-describedby="register-confirm-password-error"
              @keydown="handleKeydown"
            />
            <button type="button" class="login-eye-btn" :aria-label="showConfirmPassword ? '隐藏确认密码' : '显示确认密码'" @click="showConfirmPassword = !showConfirmPassword">
              {{ showConfirmPassword ? '隐藏' : '显示' }}
            </button>
          </div>
          <p v-if="confirmPasswordError" id="register-confirm-password-error" class="login-field-error">{{ confirmPasswordError }}</p>
        </div>

        <div class="login-field">
          <label class="login-label" for="register-bootstrap-token">部署初始化令牌</label>
          <div class="login-input-wrap">
            <input
              id="register-bootstrap-token"
              ref="bootstrapTokenInput"
              v-model="bootstrapToken"
              type="password"
              class="login-input"
              placeholder="请输入 BOOTSTRAP_TOKEN"
              autocomplete="off"
              :disabled="loading"
              :aria-invalid="!!bootstrapTokenError"
              aria-describedby="register-bootstrap-token-help register-bootstrap-token-error"
              @keydown="handleKeydown"
            />
          </div>
          <p id="register-bootstrap-token-help" class="login-field-help">该令牌由部署者通过 BOOTSTRAP_TOKEN 环境变量配置，仅首次初始化使用。</p>
          <p v-if="bootstrapTokenError" id="register-bootstrap-token-error" class="login-field-error">{{ bootstrapTokenError }}</p>
        </div>

        <button class="login-btn" :disabled="loading" @click="handleRegister">
          <span v-if="loading" class="login-btn-spinner"></span>
          {{ loading ? '请稍候...' : '创建账号' }}
        </button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.login-page {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #e8e8e8;
  padding: 16px;
}

.login-card {
  width: 100%;
  max-width: 400px;
  background: rgba(255,255,255,0.72);
  backdrop-filter: blur(40px) saturate(2);
  -webkit-backdrop-filter: blur(40px) saturate(2);
  border: 1px solid rgba(255,255,255,0.75);
  border-radius: 20px;
  box-shadow: 0 16px 48px rgba(0,0,0,0.16), 0 2px 8px rgba(0,0,0,0.08);
  padding: 40px 32px;
  position: relative;
  overflow: hidden;
}

.login-card::before {
  content: '';
  position: absolute;
  top: 0;
  left: 10%;
  right: 10%;
  height: 1px;
  background: linear-gradient(90deg, transparent, rgba(255,255,255,0.9) 30%, rgba(255,255,255,0.9) 70%, transparent);
  border-radius: 1px;
  pointer-events: none;
}

/* Logo */
.login-logo {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 12px;
  margin-bottom: 32px;
}

.login-logo-icon {
  width: 40px;
  height: 40px;
  background: rgba(10,132,255,0.75);
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #fff;
  font-size: 22px;
  font-weight: bold;
}

.login-logo-text {
  font-size: 20px;
  font-weight: 600;
  color: #1c1c1e;
}

/* Loading */
.login-loading {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 40px 0;
}

.login-spinner {
  width: 24px;
  height: 24px;
  border: 2px solid #d4d4d4;
  border-top-color: #1c1c1e;
  border-radius: 50%;
  animation: login-spin 0.6s linear infinite;
}

@keyframes login-spin {
  to { transform: rotate(360deg); }
}

/* Form */
.login-form {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.login-title {
  font-size: 22px;
  font-weight: 600;
  color: #1c1c1e;
  margin: 0;
  text-align: center;
}

.login-subtitle {
  font-size: 14px;
  color: rgba(28,28,30,.55);
  margin: -12px 0 0;
  text-align: center;
}

.login-form-error {
  padding: 10px 12px;
  border-radius: 10px;
  color: #b42318;
  background: rgba(255, 59, 48, 0.1);
  font-size: 13px;
  line-height: 1.45;
}

.login-field {
  display: flex;
  flex-direction: column;
  gap: 6px;
}

.login-label {
  font-size: 13px;
  font-weight: 500;
  color: #1c1c1e;
}

.login-field-error {
  margin: 0;
  color: #b42318;
  font-size: 12px;
  line-height: 1.4;
}

.login-field-help {
  margin: 0;
  color: rgba(28, 28, 30, 0.58);
  font-size: 12px;
  line-height: 1.4;
}

.login-input[aria-invalid="true"] {
  border-color: rgba(255, 59, 48, 0.65);
}

.login-input-wrap {
  position: relative;
  display: flex;
  align-items: center;
}

.login-input {
  width: 100%;
  height: 44px;
  padding: 0 14px;
  font-size: 15px;
  color: #1c1c1e;
  background: rgba(255,255,255,0.15);
  border: 1px solid transparent;
  border-radius: 10px;
  outline: none;
  transition: all 0.2s;
  box-sizing: border-box;
}

.login-input:focus {
  border-color: #1c1c1e;
  background: rgba(255,255,255,0.55);
}

.login-input::placeholder {
  color: rgba(28,28,30,.55);
}

.login-input:disabled {
  opacity: 0.5;
}

.login-eye-btn {
  position: absolute;
  right: 10px;
  background: none;
  border: none;
  font-size: 12px;
  color: rgba(28,28,30,.55);
  cursor: pointer;
  padding: 4px 6px;
  border-radius: 4px;
  transition: color 0.2s;
}

.login-eye-btn:hover {
  color: #1c1c1e;
}

/* Submit Button */
.login-btn {
  width: 100%;
  height: 48px;
  background: rgba(10,132,255,0.85);
  color: #fff;
  border: none;
  border-radius: 10px;
  font-size: 16px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.2s;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  margin-top: 4px;
}

.login-btn:hover {
  background: rgba(10,132,255,0.75);
}

.login-btn:active {
  transform: scale(0.98);
}

.login-btn:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.login-btn-spinner {
  width: 16px;
  height: 16px;
  border: 2px solid rgba(255, 255, 255, 0.3);
  border-top-color: #fff;
  border-radius: 50%;
  animation: login-spin 0.6s linear infinite;
}

/* Responsive: Tablet */
@media (max-width: 768px) {
  .login-card {
    padding: 32px 24px;
  }

  .login-title {
    font-size: 20px;
  }
}

/* Responsive: Small phone */
@media (max-width: 480px) {
  .login-card {
    padding: 24px 20px;
    border-radius: 12px;
  }

  .login-logo-icon {
    width: 36px;
    height: 36px;
    font-size: 20px;
  }

  .login-logo-text {
    font-size: 18px;
  }

  .login-title {
    font-size: 18px;
  }

  .login-input {
    height: 42px;
    font-size: 14px;
  }

  .login-btn {
    height: 44px;
    font-size: 15px;
  }
}
</style>
