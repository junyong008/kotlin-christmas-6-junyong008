package christmas.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BenefitsTest {
    @Test
    fun `총혜택 금액 계산`() {
        // given
        val benefits = Benefits(
            listOf(
                Benefit(BenefitType.DISCOUNT, "크리스마스 디데이", Money(1200)),
                Benefit(BenefitType.DISCOUNT, "평일", Money(4046)),
                Benefit(BenefitType.DISCOUNT, "특별", Money(1000)),
                Benefit(BenefitType.EVENT, "증정", Money(25000))
            )
        )
        // when
        val result = benefits.getTotalBenefitAmount()
        // then
        assertEquals(Money(31246), result)
    }
}