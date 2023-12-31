package christmas.domain.menu

import christmas.domain.Money

data class FreeGift(private val menu: Menu, private val menuCount: MenuCount) {
    fun getTotalPrice(): Money = menu.multiplyPriceBy(menuCount.getCount())
    override fun toString(): String = "$menu $menuCount"
}



