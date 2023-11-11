package christmas.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OrdersTest {
    @Test
    fun `주문 메뉴들을 기반으로 총주문 금액 계산`() {
        // given
        val reservationOrders = Orders.createOrdersFromString("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
        // when
        val result = reservationOrders.getTotalOrderAmount()
        // then
        assertEquals(Money(142000), result)
    }
}