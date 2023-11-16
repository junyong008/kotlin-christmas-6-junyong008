package christmas.domain.menu

import christmas.exception.OrdersException

data class MenuCount(private val count: Int) {
    init {
        require(count >= 1) { OrdersException.INVALID.message }
    }

    fun getCount() = count

    override fun toString(): String = "%,d$UNIT_SUFFIX".format(count)

    companion object {
        private const val UNIT_SUFFIX = "개"
    }
}