import { nextTick, onBeforeUnmount, watch, type Ref } from 'vue'

const FOCUSABLE = 'button:not([disabled]), [href], input:not([disabled]), select:not([disabled]), textarea:not([disabled]), [tabindex]:not([tabindex="-1"])'

export function useModalAccessibility(
  visible: Ref<boolean>,
  container: Ref<HTMLElement | null>,
  close: () => void
) {
  let returnFocus: HTMLElement | null = null

  const handleKeydown = (event: KeyboardEvent) => {
    if (!visible.value || !container.value) return
    if (event.key === 'Escape') {
      event.preventDefault()
      close()
      return
    }
    if (event.key !== 'Tab') return

    const focusable = [...container.value.querySelectorAll<HTMLElement>(FOCUSABLE)]
    if (focusable.length === 0) {
      event.preventDefault()
      container.value.focus()
      return
    }

    const first = focusable[0]!
    const last = focusable[focusable.length - 1]!
    if (event.shiftKey && document.activeElement === first) {
      event.preventDefault()
      last.focus()
    } else if (!event.shiftKey && document.activeElement === last) {
      event.preventDefault()
      first.focus()
    }
  }

  watch(visible, async (isVisible) => {
    if (isVisible) {
      returnFocus = document.activeElement instanceof HTMLElement ? document.activeElement : null
      await nextTick()
      document.addEventListener('keydown', handleKeydown)
      const first = container.value?.querySelector<HTMLElement>(FOCUSABLE)
      ;(first || container.value)?.focus()
    } else {
      document.removeEventListener('keydown', handleKeydown)
      returnFocus?.focus()
      returnFocus = null
    }
  }, { immediate: visible.value })

  onBeforeUnmount(() => document.removeEventListener('keydown', handleKeydown))
}
