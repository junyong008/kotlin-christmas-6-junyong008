package christmas.domain

data class Money(private val amount: Int) {

    fun isGreaterOrEqual(other: Money): Boolean = amount >= other.amount
    fun plus(other: Money): Money = Money(amount + other.amount)
    fun multiplyBy(input: Int): Money = Money(amount * input)
    override fun toString(): String = "%,d$UNIT_SUFFIX".format(amount)

    companion object {
        private const val UNIT_SUFFIX = "원"
    }
}