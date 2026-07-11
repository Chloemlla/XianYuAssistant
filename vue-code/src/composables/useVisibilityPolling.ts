import { onBeforeUnmount } from 'vue'

export function useVisibilityPolling(
  task: () => Promise<void>,
  delay: number,
  isEnabled: () => boolean = () => true
) {
  let timer: ReturnType<typeof setTimeout> | null = null
  let running = false
  let stopped = true

  const clearTimer = () => {
    if (timer) {
      clearTimeout(timer)
      timer = null
    }
  }

  const schedule = () => {
    clearTimer()
    if (!stopped) timer = setTimeout(run, delay)
  }

  const run = async () => {
    if (stopped || running || !isEnabled() || document.visibilityState === 'hidden') {
      schedule()
      return
    }

    running = true
    try {
      await task()
    } finally {
      running = false
      schedule()
    }
  }

  const handleVisibilityChange = () => {
    if (document.visibilityState === 'hidden') {
      clearTimer()
    } else if (!stopped) {
      void run()
    }
  }

  const start = (immediate = false) => {
    stopped = false
    document.removeEventListener('visibilitychange', handleVisibilityChange)
    document.addEventListener('visibilitychange', handleVisibilityChange)
    if (immediate) void run()
    else schedule()
  }

  const stop = () => {
    stopped = true
    clearTimer()
    document.removeEventListener('visibilitychange', handleVisibilityChange)
  }

  onBeforeUnmount(stop)

  return { start, stop, runNow: run }
}
