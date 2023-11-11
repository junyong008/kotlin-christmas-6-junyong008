package christmas.view

class OutputView {
    fun outputGreetingMessage() = println(GREETING_MESSAGE)

    fun outputBenefitPreviewTitle(day: String) = println(BENEFIT_PREVIEW_TITLE.format(day))

    fun outputOrders(orders: String) {
        println()
        println(TITLE_ORDERS)
        println(orders)
    }

    fun outputTotalOrderAmountBeforeDiscount(amount: String) {
        println()
        println(TITLE_TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT)
        println(amount)
    }

    fun outputFreeGift(freeGift: String) {
        println()
        println(TITLE_FREE_GIFT)
        println(freeGift)
    }

    companion object {
        private const val GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
        private const val BENEFIT_PREVIEW_TITLE = "12월 %s에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
        private const val TITLE_ORDERS = "<주문 메뉴>"
        private const val TITLE_TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>"
        private const val TITLE_FREE_GIFT = "<증정 메뉴>"
    }
}