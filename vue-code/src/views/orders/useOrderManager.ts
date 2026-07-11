import { ref, reactive, computed, onMounted, nextTick } from 'vue'
import { queryDeliveryRecordList, confirmShipment } from '@/api/order'
import { getAccountList } from '@/api/account'
import { getGoodsList, type GoodsItemWithConfig } from '@/api/goods'
import type { DeliveryRecordVO, DeliveryRecordQueryReq } from '@/api/order'
import type { Account } from '@/types'
import { showSuccess, showError, showConfirm, showInfo } from '@/utils'
import { formatTime } from '@/utils'
import { createLatestRequestGuard } from '@/utils/latestRequest'

export interface DeliveryRecordItem extends DeliveryRecordVO {
  confirming?: boolean
}

export function useOrderManager() {
  const loading = ref(false)
  const orderList = ref<DeliveryRecordItem[]>([])
  const total = ref(0)
  const loadError = ref('')
  const lastUpdatedAt = ref<Date | null>(null)
  const orderRequest = createLatestRequestGuard()
  const accounts = ref<Account[]>([])

  const goodsList = ref<GoodsItemWithConfig[]>([])
  const goodsTotal = ref(0)
  const goodsLoading = ref(false)
  const goodsError = ref('')
  const goodsRequest = createLatestRequestGuard()
  const goodsListRef = ref<HTMLElement | null>(null)
  const goodsCurrentPage = ref(1)
  const onlyOnSale = ref(true)
  const selectedGoodsId = ref<string | null>(null)

  const queryParams = reactive<DeliveryRecordQueryReq>({
    pageNum: 1,
    pageSize: 20
  })

  const dialogs = reactive({
    confirmShipment: false,
    filter: false
  })

  const confirmTarget = ref<DeliveryRecordItem | null>(null)

  const totalPages = computed(() => Math.ceil(total.value / (queryParams.pageSize || 20)))

  const loadAccounts = async () => {
    try {
      const response = await getAccountList()
      if (response.code === 0 || response.code === 200) {
        accounts.value = response.data?.accounts || []
        if (accounts.value.length > 0 && !queryParams.xianyuAccountId) {
          queryParams.xianyuAccountId = accounts.value[0]?.id
        }
      }
    } catch (error: any) {
      console.error('加载账号列表失败:', error)
    }
  }

  const handleAccountChange = () => {
    queryParams.pageNum = 1
    queryParams.keyword = undefined
    selectedGoodsId.value = null
    goodsCurrentPage.value = 1
    goodsList.value = []
    loadGoods()
    loadOrders()
  }

  const loadGoods = async () => {
    if (!queryParams.xianyuAccountId) {
      return
    }

    const requestId = goodsRequest.begin()
    goodsLoading.value = true
    goodsError.value = ''
    try {
      const params = {
        xianyuAccountId: queryParams.xianyuAccountId,
        onlyOnSale: onlyOnSale.value,
        pageNum: goodsCurrentPage.value,
        pageSize: 20
      }

      const response = await getGoodsList(params)
      if (!goodsRequest.isLatest(requestId)) return
      if (response.code === 0 || response.code === 200) {
        if (goodsCurrentPage.value === 1) {
          goodsList.value = response.data?.itemsWithConfig || []
        } else {
          goodsList.value.push(...(response.data?.itemsWithConfig || []))
        }
        goodsTotal.value = response.data?.totalCount || 0
        checkAndLoadMore()
      } else {
        throw new Error(response.msg || '获取商品列表失败')
      }
    } catch (error: any) {
      if (!goodsRequest.isLatest(requestId)) return
      goodsError.value = error instanceof Error ? error.message : '加载商品列表失败'
    } finally {
      if (goodsRequest.isLatest(requestId)) goodsLoading.value = false
    }
  }

  const checkAndLoadMore = () => {
    nextTick(() => {
      if (!goodsListRef.value) return
      const { scrollHeight, clientHeight } = goodsListRef.value
      if (scrollHeight <= clientHeight && goodsList.value.length < goodsTotal.value) {
        goodsCurrentPage.value++
        loadGoods()
      }
    })
  }

  const handleGoodsScroll = () => {
    if (!goodsListRef.value || goodsLoading.value) return
    const { scrollTop, scrollHeight, clientHeight } = goodsListRef.value
    if (scrollTop + clientHeight >= scrollHeight - 50) {
      if (goodsList.value.length < goodsTotal.value) {
        goodsCurrentPage.value++
        loadGoods()
      }
    }
  }

  const selectGoods = (goods: GoodsItemWithConfig) => {
    if (selectedGoodsId.value === goods.item.xyGoodId) {
      clearGoodsFilter()
      return
    }
    selectedGoodsId.value = goods.item.xyGoodId
    queryParams.xyGoodsId = goods.item.xyGoodId
    queryParams.pageNum = 1
    loadOrders()
  }

  const clearGoodsFilter = () => {
    selectedGoodsId.value = null
    queryParams.xyGoodsId = undefined
    queryParams.pageNum = 1
    loadOrders()
  }

  const toggleOnlyOnSale = () => {
    onlyOnSale.value = !onlyOnSale.value
    goodsCurrentPage.value = 1
    selectedGoodsId.value = null
    queryParams.xyGoodsId = undefined
    loadGoods()
  }

  const getStatusColor = (state: number) => {
    return state === 1 ? '#34c759' : '#ff3b30'
  }

  const getStatusBg = (state: number) => {
    return state === 1 ? 'rgba(52, 199, 89, 0.1)' : 'rgba(255, 59, 48, 0.1)'
  }

  const getStatusText = (state: number) => {
    return state === 1 ? '成功' : '失败'
  }

  const loadOrders = async () => {
    const requestId = orderRequest.begin()
    loading.value = true
    loadError.value = ''
    try {
      const response = await queryDeliveryRecordList(queryParams)
      if (!orderRequest.isLatest(requestId)) return
      orderList.value = (response.data?.records || []).map(item => ({
        ...item,
        confirming: false
      }))
      total.value = response.data?.total || 0
      lastUpdatedAt.value = new Date()
    } catch (error: any) {
      if (!orderRequest.isLatest(requestId)) return
      // 只有在错误消息未显示过时才弹出提示（避免重复显示）
      if (!error.messageShown) {
        showError('查询发货记录失败: ' + (error.message || '未知错误'))
      }
      loadError.value = error instanceof Error ? error.message : '查询发货记录失败'
    } finally {
      if (orderRequest.isLatest(requestId)) loading.value = false
    }
  }

  const handleReset = () => {
    queryParams.keyword = undefined
    queryParams.pageNum = 1
    loadOrders()
  }

  const handlePageChange = (page: number) => {
    queryParams.pageNum = page
    loadOrders()
  }

  const handleSizeChange = (size: number) => {
    queryParams.pageSize = size
    queryParams.pageNum = 1
    loadOrders()
  }

  const copySId = (sid: string) => {
    navigator.clipboard.writeText(sid).then(() => {
      showSuccess('已复制')
    }).catch(() => {
      showError('复制失败')
    })
  }

  const handleConfirmShipment = async (row: DeliveryRecordItem) => {
    if (!row.orderId) {
      showError('订单ID为空')
      return
    }
    try {
      row.confirming = true
      await confirmShipment({
        xianyuAccountId: (row as any).xianyuAccountId,
        orderId: row.orderId
      })

      showSuccess('确认发货成功')
      loadOrders()
    } catch (error: any) {
      showError('确认发货失败: ' + (error.message || '未知错误'))
    } finally {
      row.confirming = false
    }
  }

  return {
    loading,
    orderList,
    total,
    accounts,
    goodsList,
    goodsTotal,
    goodsLoading,
    goodsListRef,
    goodsCurrentPage,
    onlyOnSale,
    selectedGoodsId,
    queryParams,
    dialogs,
    confirmTarget,
    totalPages,
    loadError,
    lastUpdatedAt,
    goodsError,
    loadAccounts,
    loadOrders,
    loadGoods,
    handleAccountChange,
    handleReset,
    handlePageChange,
    handleSizeChange,
    copySId,
    handleConfirmShipment,
    handleGoodsScroll,
    selectGoods,
    clearGoodsFilter,
    toggleOnlyOnSale,
    getStatusColor,
    getStatusBg,
    getStatusText,
    formatTime
  }
}
