import type { ChatMessage } from '@/api/message'

export function mergeChatMessages(current: ChatMessage[], incoming: ChatMessage[]) {
  const byId = new Map<number, ChatMessage>()
  for (const message of current) byId.set(message.id, message)
  for (const message of incoming) byId.set(message.id, { ...byId.get(message.id), ...message })

  return [...byId.values()].sort((left, right) => {
    const timeDelta = Number(left.messageTime) - Number(right.messageTime)
    return timeDelta || left.id - right.id
  })
}
