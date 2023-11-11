package christmas.service

import christmas.domain.DecemberDay
import christmas.domain.DecemberEvent
import christmas.domain.Orders

class DecemberEventService {

    private val decemberEvent = DecemberEvent()

    fun getReservationDay(input: String): DecemberDay = DecemberDay.fromString(input)

    fun getReservationOrders(input: String): Orders = Orders.fromString(input)
}