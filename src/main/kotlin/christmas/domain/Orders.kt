package christmas.domain

import christmas.exception.OrdersException
import java.util.EnumMap

class Orders private constructor(private val orders: EnumMap<Menu, MenuCount>) {

    fun getTotalOrderAmount(): Money =
        orders.entries.fold(Money(0)) { acc, (menu, menuCount) ->
            val orderPrice = menu.multiplyPriceBy(menuCount.getCount())
            acc.plus(orderPrice)
        }

    fun getMenuCountInCategory(category: MenuCategory): MenuCount {
        val filteredMenus = orders.filter { it.key.isCategorySame(category) }
        val menuCount = filteredMenus.values.sumOf { it.getCount() }
        return MenuCount(menuCount)
    }

    override fun toString(): String =
        orders.entries.joinToString("\n") { (menu, menuCount) -> "$menu $menuCount" }

    companion object {
        fun fromString(input: String): Orders {
            val inputOrders = input.split(",")
            val outputOrders = EnumMap<Menu, MenuCount>(Menu::class.java)
            inputOrders.forEach {
                val (menuTitle, menuCount) = it.split("-")
                val menu = checkMenuExist(menuTitle)
                val count = checkInteger(menuCount)
                checkDuplicatedMenu(menu, outputOrders)

                outputOrders[menu] = MenuCount(count)
            }
            return Orders(outputOrders)
        }

        private fun checkMenuExist(menuTitle: String): Menu {
            val menu = Menu.getMenuByTitle(menuTitle)
            return requireNotNull(menu) { OrdersException.INVALID.message }
        }

        private fun checkInteger(input: String): Int =
            requireNotNull(input.toIntOrNull()) { OrdersException.INVALID.message }

        private fun checkDuplicatedMenu(menu: Menu, orders: EnumMap<Menu, MenuCount>) {
            require(!orders.containsKey(menu)) { OrdersException.INVALID.message }
        }
    }
}