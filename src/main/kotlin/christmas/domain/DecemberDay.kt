package christmas.domain

import christmas.exception.DecemberDayException

data class DecemberDay(private val day: Int) {
    init {
        require(day in DAY_START..DAY_END) { DecemberDayException.INVALID.message }
    }

    fun hasPassedChristmas() = day > DAY_CHRISTMAS
    fun getDaySinceStartOfMonth() = day - DAY_START
    fun isWeekEnd() = day in WEEKENDS
    fun isSpecialDay() = day in SPECIAL_DAYS

    companion object {
        private const val DAY_START = 1
        private const val DAY_END = 31
        private const val DAY_CHRISTMAS = 25
        private val WEEKENDS = listOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
        private val SPECIAL_DAYS = listOf(3, 10, 17, 24, 25, 31)

        fun fromString(input: String): DecemberDay {
            val day = requireNotNull(input.toIntOrNull()) { DecemberDayException.INVALID.message }
            return DecemberDay(day)
        }
    }
}