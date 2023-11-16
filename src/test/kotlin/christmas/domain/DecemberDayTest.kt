package christmas.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DecemberDayTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 31, 20])
    fun `객체 생성 - 정상 입력`(input: Int) {
        // when & then
        assertDoesNotThrow { DecemberDay(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 32, 50])
    fun `객체 생성 - 범위 초과 예외 처리`(input: Int) {
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { DecemberDay(input) }
            .withMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
    }

    @Test
    fun `문자열로 객체 생성 - 정상 입력`() {
        // given
        val input = "30"
        // when
        val result = DecemberDay.fromString(input)
        // then
        assertEquals(DecemberDay(30), result)
    }

    @Test
    fun `문자열로 객체 생성 - 빈 값 입력 예외 처리`() {
        // given
        val input = ""
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { DecemberDay.fromString(input) }
            .withMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "abcd", "2147483648", "-2147483649"])
    fun `문자열로 객체 생성 - Int 범위 초과 입력 예외 처리`(input: String) {
        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { DecemberDay.fromString(input) }
            .withMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
    }

    @Test
    fun `크리스마스를 지났는지 확인`() {
        // given
        val input = DecemberDay(26)
        // when
        val result = input.hasPassedChristmas()
        // then
        assertEquals(true, result)
    }

    @Test
    fun `달의 시작일로부터 몇일이 지났는지 계산`() {
        // given
        val input = DecemberDay(17)
        // when
        val result = input.getDaySinceStartOfMonth()
        // then
        assertEquals(16, result)
    }

    @Test
    fun `주말인지 확인`() {
        // given
        val input = DecemberDay(17)
        // when
        val result = input.isWeekEnd()
        // then
        assertEquals(false, result)
    }

    @Test
    fun `별이 있는 날인지 확인`() {
        // given
        val input = DecemberDay(17)
        // when
        val result = input.isSpecialDay()
        // then
        assertEquals(true, result)
    }
}