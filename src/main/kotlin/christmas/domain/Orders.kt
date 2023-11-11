package christmas.domain

import java.util.EnumMap

class Orders private constructor(private val orders: EnumMap<Menu, MenuCount>) {

    fun getTotalOrderAmount(): Money {
        return orders.entries.fold(Money(0)) { acc, (menu, menuCount) ->
            val orderPrice = menu.multiplyPriceBy(menuCount.getCount())
            acc.plus(orderPrice)
        }
    }

    fun getMenuCountInCategory(category: MenuCategory): MenuCount {
        val filteredMenus = orders.filter { it.key.isCategorySame(category) }
        val menuCount = filteredMenus.values.sumOf { it.getCount() }
        return MenuCount(menuCount)
    }

    override fun toString(): String =
        orders.entries.joinToString("\n") { (menu, menuCount) -> "$menu $menuCount" }

    companion object {
        fun createOrdersFromString(input: String): Orders {
            val inputOrders = input.split(",")
            val outputOrders = EnumMap<Menu, MenuCount>(Menu::class.java)

            for (order in inputOrders) {
                val (menuTitle, menuCount) = order.split("-")
                val menu = Menu.getMenuByTitle(menuTitle)
                val count = menuCount.toInt()
                outputOrders[menu] = MenuCount(count)
            }

            return Orders(outputOrders)
        }
    }
}