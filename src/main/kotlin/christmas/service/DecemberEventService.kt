package christmas.service

import christmas.domain.DecemberDay
import christmas.domain.DecemberEvent

class DecemberEventService {

    private val decemberEvent = DecemberEvent()

    fun getReservationDay(input: String) : DecemberDay = DecemberDay.fromString(input)
}