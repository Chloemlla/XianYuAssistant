import { describe, expect, it } from 'vitest'
import { createLatestRequestGuard } from '../latestRequest'

describe('createLatestRequestGuard', () => {
  it('rejects a response after a newer request starts', () => {
    const guard = createLatestRequestGuard()
    const first = guard.begin()
    const second = guard.begin()

    expect(guard.isLatest(first)).toBe(false)
    expect(guard.isLatest(second)).toBe(true)
  })
})
