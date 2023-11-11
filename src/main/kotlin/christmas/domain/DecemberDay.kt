package christmas.domain

class DecemberDay(private val day: Int) {

    fun hasPassedChristmas() = day > DAY_CHRISTMAS
    fun getDaySinceStartOfMonth() = day - DAY_START
    fun isWeekEnd() = day in WEEKENDS
    fun isSpecialDay() = day in SPECIAL_DAYS

    companion object {
        private const val DAY_START = 1
        private const val DAY_CHRISTMAS = 25
        private val WEEKENDS = listOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
        private val SPECIAL_DAYS = listOf(3, 10, 17, 24, 25, 31)
    }
}