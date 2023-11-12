package christmas.domain.order

import christmas.domain.Money

class FreeGift(
    private val menu: Menu,
    private val menuCount: MenuCount
) {
    fun getTotalPrice(): Money = menu.multiplyPriceBy(menuCount.getCount())
    override fun toString(): String = "$menu $menuCount"
}



