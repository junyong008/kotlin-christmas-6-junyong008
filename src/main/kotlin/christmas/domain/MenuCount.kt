package christmas.domain

class MenuCount(private val count: Int) {

    fun getCount() = count

    override fun toString(): String = "%,d$UNIT_SUFFIX".format(count)

    companion object {
        private const val UNIT_SUFFIX = "개"
    }
}