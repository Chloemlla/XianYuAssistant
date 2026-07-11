import axios, { type AxiosInstance, type AxiosRequestConfig, type AxiosResponse } from 'axios'
import { toast } from './toast'
import type { ApiResponse } from '@/types'

// Token存储key
const TOKEN_KEY = 'xianyu_auth_token'
const REFRESH_TOKEN_KEY = 'xianyu_auth_refresh_token'
const USERNAME_KEY = 'xianyu_auth_username'

/** 获取Token */
export function getAuthToken(): string | null {
  return localStorage.getItem(TOKEN_KEY)
}

/** 设置Token */
export function setAuthToken(token: string, refreshToken: string, username: string) {
  localStorage.setItem(TOKEN_KEY, token)
  localStorage.setItem(REFRESH_TOKEN_KEY, refreshToken)
  localStorage.setItem(USERNAME_KEY, username)
}

export function getRefreshToken(): string | null {
  return localStorage.getItem(REFRESH_TOKEN_KEY)
}

/** 清除Token */
export function clearAuthToken() {
  localStorage.removeItem(TOKEN_KEY)
  localStorage.removeItem(REFRESH_TOKEN_KEY)
  localStorage.removeItem(USERNAME_KEY)
}

/** 获取用户名 */
export function getAuthUsername(): string | null {
  return localStorage.getItem(USERNAME_KEY)
}

/** 是否已登录 */
export function isLoggedIn(): boolean {
  return !!getAuthToken()
}

// 创建 axios 实例
const service: AxiosInstance = axios.create({
  baseURL: '/api',
  timeout: 30000,
  headers: {
    'Content-Type': 'application/json'
  }
})

interface AuthSession {
  token: string
  refreshToken: string
  username: string
}

interface RetriableRequestConfig extends AxiosRequestConfig {
  _authRetry?: boolean
}

let refreshPromise: Promise<string> | null = null

export const refreshAccessToken = () => {
  if (!refreshPromise) {
    const refreshToken = getRefreshToken()
    if (!refreshToken) return Promise.reject(new Error('登录已过期，请重新登录'))

    refreshPromise = axios.post<ApiResponse<AuthSession>>('/api/login/refresh', { refreshToken }, {
      timeout: 30000,
      headers: { 'Content-Type': 'application/json' }
    }).then(response => {
      const result = response.data
      if ((result.code !== 0 && result.code !== 200) || !result.data?.token || !result.data.refreshToken) {
        throw new Error(result.msg || '刷新登录状态失败')
      }
      setAuthToken(result.data.token, result.data.refreshToken, result.data.username || getAuthUsername() || '')
      return result.data.token
    }).finally(() => {
      refreshPromise = null
    })
  }
  return refreshPromise
}

export const resetAuthRefreshForTests = () => {
  refreshPromise = null
}

const retryWithRefresh = async (config: RetriableRequestConfig) => {
  if (config._authRetry || config.url?.includes('/login/')) {
    throw new Error('登录已过期，请重新登录')
  }
  config._authRetry = true
  const token = await refreshAccessToken()
  config.headers = { ...config.headers, Authorization: `Bearer ${token}` }
  return service.request(config)
}

const expireSession = (message: string) => {
  clearAuthToken()
  if (!window.location.pathname.includes('/login')) {
    toast.error(message)
    window.location.href = '/login'
  }
}

// 请求拦截器
service.interceptors.request.use(
  (config) => {
    // 添加Token到请求头
    const token = getAuthToken()
    if (token) {
      config.headers.Authorization = `Bearer ${token}`
    }
    return config
  },
  (error) => {
    return Promise.reject(error)
  }
)

// 响应拦截器
service.interceptors.response.use(
  async (response: AxiosResponse<ApiResponse<any>>) => {
    const res = response.data

    // 401未登录 -> 跳转登录页
    if (res.code === 401) {
      try {
        return await retryWithRefresh(response.config as RetriableRequestConfig)
      } catch {
        expireSession(res.msg || '登录已过期，请重新登录')
        return Promise.reject(new Error(res.msg || '未登录'))
      }
    }

    // 特殊处理：1001是滑块验证码，需要业务代码自己处理，不在这里拦截
    if (res.code === 1001) {
      return response // 直接返回，让业务代码处理
    }

    // 如果响应码不是 0 或 200，认为是错误
    if (res.code !== 0 && res.code !== 200) {
      const errorMsg = res.msg || res.message || '请求失败'
      toast.error(errorMsg)
      const error = new Error(errorMsg)
      // 标记这个错误已经显示过消息，避免重复提示
      ;(error as any).messageShown = true
      return Promise.reject(error)
    }

    return response // 保持返回完整的 AxiosResponse
  },
  async (error) => {
    if (error?.response?.status === 401 && error.config) {
      try {
        return await retryWithRefresh(error.config as RetriableRequestConfig)
      } catch {
        expireSession('登录已过期，请重新登录')
        return Promise.reject(new Error('登录已过期，请重新登录'))
      }
    }
    // 只有在错误消息未显示过时才弹出提示
    if (!(error as any).messageShown) {
      toast.error(error.message || '网络请求失败')
    }
    return Promise.reject(error)
  }
)

// 封装请求方法
export function request<T = any>(config: AxiosRequestConfig): Promise<ApiResponse<T>> {
  return service.request<ApiResponse<T>>(config).then(response => response.data)
}

export default service
