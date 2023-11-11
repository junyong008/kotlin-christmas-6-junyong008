package christmas.domain

class Benefits(private val benefits: List<Benefit>) {

    fun getTotalBenefitAmount(): Money =
        benefits.fold(Money(0)) { acc, benefit -> acc.plus(benefit.getAmount()) }

    fun getTotalDiscountAmount(): Money =
        benefits
            .filter { it.isDiscountType() }
            .fold(Money(0)) { acc, benefit -> acc.plus(benefit.getAmount()) }

    override fun toString(): String = benefits.joinToString("\n")
}