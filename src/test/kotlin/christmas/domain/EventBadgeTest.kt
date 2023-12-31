package christmas.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EventBadgeTest {
    @Test
    fun `총혜택 금액에 따른 배지 계산`() {
        // given
        val totalBenefitAmount = Money(-10000)
        // when
        val result = EventBadge.getBadge(totalBenefitAmount)
        // then
        assertEquals(EventBadge.TREE, result)
    }
}