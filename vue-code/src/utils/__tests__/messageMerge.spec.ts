import { describe, expect, it } from 'vitest'
import { mergeChatMessages } from '../messageMerge'
import type { ChatMessage } from '@/api/message'

const message = (id: number, messageTime: number): ChatMessage => ({
  id,
  messageTime,
  xianyuAccountId: 1,
  lwp: '',
  pnmId: '',
  sid: 'session',
  contentType: 1,
  msgContent: String(id),
  senderUserName: 'user',
  senderUserId: 'user',
  senderAppV: '',
  senderOsType: '',
  reminderUrl: '',
  xyGoodsId: '',
  completeMsg: '',
  createTime: ''
})

describe('mergeChatMessages', () => {
  it('keeps loaded history while adding and deduplicating live messages', () => {
    const result = mergeChatMessages(
      [message(1, 1), message(2, 2)],
      [message(2, 2), message(3, 3)]
    )

    expect(result.map(item => item.id)).toEqual([1, 2, 3])
  })
})
