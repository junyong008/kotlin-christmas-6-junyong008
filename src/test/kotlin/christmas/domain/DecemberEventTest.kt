package christmas.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DecemberEventTest {

    private val decemberEvent = DecemberEvent()

    @Test
    fun `방문 날짜와 주문 정보를 기반으로 이벤트 혜택 계산 - 평일 포함`() {
        // given
        val reservationDay = DecemberDay(3)
        val reservationOrders = Orders.fromString("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
        // when
        val result = decemberEvent.getBenefits(reservationDay, reservationOrders)
        // then
        val expectedValue = """
            크리스마스 디데이 할인: -1,200원
            평일 할인: -4,046원
            특별 할인: -1,000원
            증정 이벤트: -25,000원
        """.trimIndent()
        assertEquals(expectedValue, result.toString())
    }

    @Test
    fun `방문 날짜와 주문 정보를 기반으로 이벤트 혜택 계산 - 주말 포함`() {
        // given
        val reservationDay = DecemberDay(22)
        val reservationOrders = Orders.fromString("티본스테이크-2,바비큐립-1,초코케이크-2,제로콜라-1")
        // when
        val result = decemberEvent.getBenefits(reservationDay, reservationOrders)
        // then
        val expectedValue = """
            크리스마스 디데이 할인: -3,100원
            주말 할인: -6,069원
            증정 이벤트: -25,000원
        """.trimIndent()
        assertEquals(expectedValue, result.toString())
    }

    @Test
    fun `총주문 금액을 기반으로 증정 메뉴 얻기`() {
        // given
        val totalOrderAmount = Money(120000)
        // when
        val result = decemberEvent.getFreeGift(totalOrderAmount)
        // then
        assertEquals("샴페인 1개", result.toString())
    }
}