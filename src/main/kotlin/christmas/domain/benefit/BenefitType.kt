package christmas.domain.benefit

enum class BenefitType(private val type: String) {
    DISCOUNT("할인"),
    EVENT("이벤트");

    override fun toString(): String = type
}