package christmas.domain.order

import christmas.domain.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OrdersTest {
    @Test
    fun `문자열로 객체 생성 - 정상 입력`() {
        // given
        val input = "타파스-1,제로콜라-3,해산물파스타-3"
        // when & then
        assertDoesNotThrow { Orders.fromString(input) }
    }

    @Test
    fun `문자열로 객체 생성 - 빈 값 입력 예외 처리`() {
        // given
        val input = ""
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Orders.fromString(input) }
            .withMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    }

    @Test
    fun `문자열로 객체 생성 - 메뉴판에 없는 메뉴 입력 예외 처리`() {
        // given
        val input = "제로콜라-1,탕후루-4"
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Orders.fromString(input) }
            .withMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    }

    @Test
    fun `문자열로 객체 생성 - 메뉴의 개수를 1미만으로 입력 예외 처리`() {
        // given
        val input = "레드와인-0,초코케이크-4"
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Orders.fromString(input) }
            .withMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    }

    @Test
    fun `문자열로 객체 생성 - 가이드 미준수 입력 예외 처리`() {
        // given
        val input = "초코케이크:1/제로콜라:3/레드와인 - 2"
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Orders.fromString(input) }
            .withMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    }

    @Test
    fun `문자열로 객체 생성 - 중복 메뉴 입력 예외 처리`() {
        // given
        val input = "레드와인-1,초코케이크-4,샴페인-2,레드와인-7"
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Orders.fromString(input) }
            .withMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    }

    @Test
    fun `문자열로 객체 생성 - 메뉴 개수 20개 초과 예외 처리`() {
        // given
        val input = "양송이수프-10,타파스-11"
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Orders.fromString(input) }
            .withMessage("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.")
    }

    @Test
    fun `문자열로 객체 생성 - 음료만 주문시 예외 처리`() {
        // given
        val input = "제로콜라-4,샴페인-2"
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Orders.fromString(input) }
            .withMessage("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요.")
    }

    @Test
    fun `주문 메뉴들을 기반으로 총주문 금액 계산`() {
        // given
        val reservationOrders = Orders.fromString("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
        // when
        val result = reservationOrders.getTotalOrderAmount()
        // then
        assertEquals(Money(142000), result)
    }

    @Test
    fun `특정 카테고리의 주문 개수 계산 - 정상 입력`() {
        // given
        val orders = Orders.fromString("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
        val category = MenuCategory.DESSERT
        // when
        val result = orders.getMenuCountInCategory(category)
        // then
        assertEquals(MenuCount(2), result)
    }

    @Test
    fun `특정 카테고리의 주문 개수 계산 - 해당하는 카테고리가 없는 경우 null 반환`() {
        // given
        val orders = Orders.fromString("티본스테이크-1,바비큐립-1,제로콜라-1")
        val category = MenuCategory.DESSERT
        // when
        val result = orders.getMenuCountInCategory(category)
        // then
        assertEquals(null, result)
    }

    @Test
    fun `문자열 출력`() {
        // given
        val input = Orders.fromString("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
        // when
        val result = input.toString()
        // then
        val expectedValue = """
            티본스테이크 1개
            바비큐립 1개
            초코케이크 2개
            제로콜라 1개
        """.trimIndent()
        assertEquals(expectedValue, result)
    }
}