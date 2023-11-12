package christmas.domain.menu

import christmas.domain.Money

enum class Menu(
    private val category: MenuCategory,
    private val title: String,
    private val price: Money
) {
    MUSHROOM_SOUP(MenuCategory.APPETIZER, "양송이수프", Money(6000)),
    TAPAS(MenuCategory.APPETIZER, "타파스", Money(5500)),
    CAESAR_SALAD(MenuCategory.APPETIZER, "시저샐러드", Money(8000)),
    T_BONE_STEAK(MenuCategory.MAIN, "티본스테이크", Money(55000)),
    BBQ_RIBS(MenuCategory.MAIN, "바비큐립", Money(54000)),
    SEAFOOD_PASTA(MenuCategory.MAIN, "해산물파스타", Money(35000)),
    CHRISTMAS_PASTA(MenuCategory.MAIN, "크리스마스파스타", Money(25000)),
    CHOCOLATE_CAKE(MenuCategory.DESSERT, "초코케이크", Money(15000)),
    ICE_CREAM(MenuCategory.DESSERT, "아이스크림", Money(5000)),
    ZERO_COLA(MenuCategory.BEVERAGE, "제로콜라", Money(3000)),
    RED_WINE(MenuCategory.BEVERAGE, "레드와인", Money(60000)),
    CHAMPAGNE(MenuCategory.BEVERAGE, "샴페인", Money(25000));

    fun multiplyPriceBy(factor: Int): Money = price.multiplyBy(factor)
    fun isCategorySame(other: MenuCategory) = (category == other)
    override fun toString(): String = title

    companion object {
        fun getMenuByTitle(input: String): Menu? = entries.find { it.title == input }
    }
}