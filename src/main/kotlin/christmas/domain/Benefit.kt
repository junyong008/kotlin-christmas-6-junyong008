package christmas.domain

class Benefit(
    private val type: BenefitType,
    private val name: String,
    private val amount: Money,
) {
    fun getAmount() = amount
    override fun toString(): String = "$name $type: -$amount"
}