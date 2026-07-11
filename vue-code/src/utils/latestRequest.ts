export function createLatestRequestGuard() {
  let sequence = 0

  return {
    begin() {
      sequence += 1
      return sequence
    },
    isLatest(requestId: number) {
      return requestId === sequence
    },
    invalidate() {
      sequence += 1
    }
  }
}
