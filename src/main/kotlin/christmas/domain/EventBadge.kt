package christmas.domain

enum class EventBadge(
    private val badgeName: String,
    private val minAmount: Money,
) {
    SANTA("산타", Money(20000)),
    TREE("트리", Money(10000)),
    STAR("별", Money(5000)),
    NOTHING("없음", Money(0));

    companion object {
        fun getBadge(totalBenefitAmount: Money): EventBadge =
            entries.firstOrNull { totalBenefitAmount.isGreaterOrEqual(it.minAmount) }?: NOTHING
    }
}