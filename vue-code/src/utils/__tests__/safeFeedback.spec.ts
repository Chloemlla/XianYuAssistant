import { afterEach, describe, expect, it, vi } from 'vitest'
import { toast } from '../toast'
import { showConfirm } from '../confirm'

afterEach(() => {
  document.body.innerHTML = ''
  vi.useRealTimers()
})

describe('safe feedback rendering', () => {
  it('renders toast messages as text', () => {
    vi.useFakeTimers()
    toast.error('<img src=x onerror=alert(1)>')

    expect(document.body.querySelector('img')).toBeNull()
    expect(document.body.textContent).toContain('<img src=x onerror=alert(1)>')
  })

  it('renders confirm title and message as text', async () => {
    const pending = showConfirm('<img src=x>', '<script>bad</script>').catch(() => undefined)

    expect(document.body.querySelector('img')).toBeNull()
    expect(document.body.querySelector('script')).toBeNull()
    expect(document.body.textContent).toContain('<img src=x>')
    ;(document.querySelector('button') as HTMLButtonElement).click()
    await pending
  })
})
