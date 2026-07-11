import axios from 'axios'
import { afterEach, describe, expect, it, vi } from 'vitest'
import { getAuthToken, getRefreshToken, refreshAccessToken, resetAuthRefreshForTests, setAuthToken } from '../request'

afterEach(() => {
  localStorage.clear()
  resetAuthRefreshForTests()
  vi.restoreAllMocks()
})

describe('auth refresh', () => {
  it('shares one refresh request and rotates both tokens', async () => {
    setAuthToken('expired-access', 'old-refresh', 'admin')
    const post = vi.spyOn(axios, 'post').mockResolvedValue({
      data: {
        code: 200,
        data: { token: 'new-access', refreshToken: 'new-refresh', username: 'admin' }
      }
    })

    const [first, second] = await Promise.all([refreshAccessToken(), refreshAccessToken()])

    expect(first).toBe('new-access')
    expect(second).toBe('new-access')
    expect(post).toHaveBeenCalledTimes(1)
    expect(getAuthToken()).toBe('new-access')
    expect(getRefreshToken()).toBe('new-refresh')
  })
})
