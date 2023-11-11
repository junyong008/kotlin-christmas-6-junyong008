package christmas.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DecemberEventTest {

    private val decemberEvent = DecemberEvent()

    @Test
    fun `방문 날짜와 주문 정보를 기반으로 이벤트 혜택 계산`() {
        // given
        val reservationDay = DecemberDay(3)
        val reservationOrders = Orders.createOrdersFromString("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
        // when
        val result = decemberEvent.getBenefits(reservationDay, reservationOrders)
        // then
        val expectedValue = """
            크리스마스 디데이 할인: -1,200원
            평일 할인: -4,046원
            특별 할인: -1,000원
            증정 이벤트: -25,000원
        """.trimIndent()
        val resultValue = result.toString()
        assertEquals(expectedValue, resultValue)
    }
}