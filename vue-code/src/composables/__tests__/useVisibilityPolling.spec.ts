import { defineComponent, h } from 'vue'
import { mount } from '@vue/test-utils'
import { afterEach, describe, expect, it, vi } from 'vitest'
import { useVisibilityPolling } from '../useVisibilityPolling'

afterEach(() => {
  vi.useRealTimers()
})

describe('useVisibilityPolling', () => {
  it('stays single-flight and pauses while the page is hidden', async () => {
    vi.useFakeTimers()
    let visibility: DocumentVisibilityState = 'visible'
    Object.defineProperty(document, 'visibilityState', { configurable: true, get: () => visibility })

    let resolveTask: (() => void) | undefined
    const task = vi.fn(() => new Promise<void>(resolve => { resolveTask = resolve }))
    const wrapper = mount(defineComponent({
      setup() {
        const polling = useVisibilityPolling(task, 1000)
        polling.start(true)
        return () => h('div')
      }
    }))

    expect(task).toHaveBeenCalledTimes(1)
    await vi.advanceTimersByTimeAsync(3000)
    expect(task).toHaveBeenCalledTimes(1)

    resolveTask?.()
    await Promise.resolve()
    visibility = 'hidden'
    document.dispatchEvent(new Event('visibilitychange'))
    await vi.advanceTimersByTimeAsync(3000)
    expect(task).toHaveBeenCalledTimes(1)

    visibility = 'visible'
    document.dispatchEvent(new Event('visibilitychange'))
    expect(task).toHaveBeenCalledTimes(2)
    wrapper.unmount()
  })
})
