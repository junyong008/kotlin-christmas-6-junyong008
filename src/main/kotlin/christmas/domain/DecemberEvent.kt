package christmas.domain

import christmas.domain.benefit.Benefit
import christmas.domain.benefit.BenefitType
import christmas.domain.benefit.Benefits
import christmas.domain.menu.*

class DecemberEvent {

    fun getFreeGift(totalOrderAmount: Money): FreeGift? {
        if (!totalOrderAmount.isGreaterOrEqual(MIN_ORDER_AMOUNT_FOR_FREE_GIFT)) return null
        return FreeGift(FREE_GIFT_MENU, FREE_GIFT_MENU_COUNT)
    }

    fun getBenefits(reservationDay: DecemberDay, reservationOrders: Orders): Benefits? {
        val totalOrderAmount = reservationOrders.getTotalOrderAmount()
        if (!totalOrderAmount.isGreaterOrEqual(MIN_ORDER_AMOUNT_FOR_EVENT)) return null

        val benefits = listOfNotNull(
            getChristmasDDayDiscountBenefit(reservationDay),
            getWeekDayDiscountBenefit(reservationDay, reservationOrders),
            getWeekEndDiscountBenefit(reservationDay, reservationOrders),
            getSpecialDiscountBenefit(reservationDay),
            getFreeGiftBenefit(totalOrderAmount)
        )
        return benefits.takeIf { it.isNotEmpty() }?.let { Benefits(it) }
    }

    private fun getChristmasDDayDiscountBenefit(reservationDay: DecemberDay): Benefit? {
        if (reservationDay.hasPassedChristmas()) return null
        val daySinceStartOfMonth = reservationDay.getDaySinceStartOfMonth()
        val discountPerDay = DISCOUNT_CHRISTMAS_PER_D_DAY.multiplyBy(daySinceStartOfMonth)
        val discountAmount = DISCOUNT_CHRISTMAS_START_D_DAY.plus(discountPerDay)
        return Benefit(BENEFIT_CHRISTMAS_D_DAY_TYPE, BENEFIT_CHRISTMAS_D_DAY_TITLE, discountAmount)
    }

    private fun getWeekDayDiscountBenefit(reservationDay: DecemberDay, reservationOrders: Orders): Benefit? {
        if (reservationDay.isWeekEnd()) return null
        val discountMenuCount = reservationOrders.getMenuCountInCategory(WEEKDAY_DISCOUNT_CATEGORY) ?: return null
        val discountAmount = DISCOUNT_WEEKDAY_PER_MENU.multiplyBy(discountMenuCount.getCount())
        return Benefit(BENEFIT_WEEKDAY_TYPE, BENEFIT_WEEKDAY_TITLE, discountAmount)
    }

    private fun getWeekEndDiscountBenefit(reservationDay: DecemberDay, reservationOrders: Orders): Benefit? {
        if (!reservationDay.isWeekEnd()) return null
        val discountMenuCount = reservationOrders.getMenuCountInCategory(WEEKEND_DISCOUNT_CATEGORY) ?: return null
        val discountAmount = DISCOUNT_WEEKEND_PER_MENU.multiplyBy(discountMenuCount.getCount())
        return Benefit(BENEFIT_WEEKEND_TYPE, BENEFIT_WEEKEND_TITLE, discountAmount)
    }

    private fun getSpecialDiscountBenefit(reservationDay: DecemberDay): Benefit? {
        if (!reservationDay.isSpecialDay()) return null
        return Benefit(BENEFIT_SPECIAL_TYPE, BENEFIT_SPECIAL_TITLE, DISCOUNT_SPECIAL)
    }

    private fun getFreeGiftBenefit(totalOrderAmount: Money): Benefit? {
        val freeGift = getFreeGift(totalOrderAmount) ?: return null
        val benefitAmount = freeGift.getTotalPrice()
        return Benefit(BENEFIT_FREE_GIFT_TYPE, BENEFIT_FREE_GIFT_TITLE, benefitAmount.toNegative())
    }

    companion object {
        private val MIN_ORDER_AMOUNT_FOR_EVENT = Money(10000)

        private const val BENEFIT_CHRISTMAS_D_DAY_TITLE = "크리스마스 디데이"
        private val BENEFIT_CHRISTMAS_D_DAY_TYPE = BenefitType.DISCOUNT
        private val DISCOUNT_CHRISTMAS_START_D_DAY = Money(-1000)
        private val DISCOUNT_CHRISTMAS_PER_D_DAY = Money(-100)

        private const val BENEFIT_WEEKDAY_TITLE = "평일"
        private val BENEFIT_WEEKDAY_TYPE = BenefitType.DISCOUNT
        private val WEEKDAY_DISCOUNT_CATEGORY = MenuCategory.DESSERT
        private val DISCOUNT_WEEKDAY_PER_MENU = Money(-2023)

        private const val BENEFIT_WEEKEND_TITLE = "주말"
        private val BENEFIT_WEEKEND_TYPE = BenefitType.DISCOUNT
        private val WEEKEND_DISCOUNT_CATEGORY = MenuCategory.MAIN
        private val DISCOUNT_WEEKEND_PER_MENU = Money(-2023)

        private const val BENEFIT_SPECIAL_TITLE = "특별"
        private val BENEFIT_SPECIAL_TYPE = BenefitType.DISCOUNT
        private val DISCOUNT_SPECIAL = Money(-1000)

        private const val BENEFIT_FREE_GIFT_TITLE = "증정"
        private val BENEFIT_FREE_GIFT_TYPE = BenefitType.EVENT
        private val FREE_GIFT_MENU = Menu.CHAMPAGNE
        private val FREE_GIFT_MENU_COUNT = MenuCount(1)
        private val MIN_ORDER_AMOUNT_FOR_FREE_GIFT = Money(120000)
    }
}