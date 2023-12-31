package christmas.domain.menu

import christmas.domain.Money
import christmas.exception.OrdersException
import java.util.EnumMap

class Orders private constructor(private val orders: EnumMap<Menu, MenuCount>) {

    fun getTotalOrderAmount(): Money = orders.entries.fold(Money(0)) { acc, (menu, menuCount) ->
        val orderPrice = menu.multiplyPriceBy(menuCount.getCount())
        acc.plus(orderPrice)
    }

    fun getMenuCountInCategory(category: MenuCategory): MenuCount? {
        val filteredMenus = orders.filter { it.key.isCategorySame(category) }
        if (filteredMenus.isEmpty()) return null
        val menuCount = filteredMenus.values.sumOf { it.getCount() }
        return MenuCount(menuCount)
    }

    override fun toString(): String =
        orders.entries.joinToString(System.lineSeparator()) { (menu, menuCount) -> "$menu $menuCount" }

    companion object {

        private const val DELIMITER_ORDERS = ","
        private const val DELIMITER_ORDER = "-"
        private const val MAX_MENU_COUNT = 20

        fun fromString(input: String): Orders {
            val inputOrders = input.split(DELIMITER_ORDERS)
            val outputOrders = EnumMap<Menu, MenuCount>(Menu::class.java)
            inputOrders.forEach {
                val (menuTitle, menuCount) = splitOrder(it)
                val menu = getMenu(menuTitle)
                val count = getCount(menuCount)
                checkDuplicatedMenu(menu, outputOrders)

                outputOrders[menu] = MenuCount(count)
            }
            checkMenuCount(outputOrders)
            checkOnlyBeverage(outputOrders)
            return Orders(outputOrders)
        }

        private fun splitOrder(order: String): List<String> {
            require(order.contains(DELIMITER_ORDER)) { OrdersException.INVALID.message }
            return order.split(DELIMITER_ORDER)
        }

        private fun getMenu(menuTitle: String): Menu {
            val menu = Menu.getMenuByTitle(menuTitle)
            return requireNotNull(menu) { OrdersException.INVALID.message }
        }

        private fun getCount(input: String): Int =
            requireNotNull(input.toIntOrNull()) { OrdersException.INVALID.message }

        private fun checkDuplicatedMenu(menu: Menu, orders: EnumMap<Menu, MenuCount>) =
            require(!orders.containsKey(menu)) { OrdersException.INVALID.message }

        private fun checkMenuCount(orders: EnumMap<Menu, MenuCount>) {
            val menuCounts = orders.values
            val totalMenuCount = menuCounts.sumOf { it.getCount() }
            require(totalMenuCount <= MAX_MENU_COUNT) { OrdersException.EXCEED_MAX_MENU_COUNT.message }
        }

        private fun checkOnlyBeverage(orders: EnumMap<Menu, MenuCount>) {
            val nonBeverageMenus = orders.filterNot { it.key.isCategorySame(MenuCategory.BEVERAGE) }
            require(nonBeverageMenus.isNotEmpty()) { OrdersException.ONLY_BEVERAGE.message }
        }
    }
}