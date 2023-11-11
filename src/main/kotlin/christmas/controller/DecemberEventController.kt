package christmas.controller

import christmas.domain.DecemberDay
import christmas.domain.DecemberEvent
import christmas.domain.Orders
import christmas.service.DecemberEventService
import christmas.view.InputView
import christmas.view.OutputView

class DecemberEventController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val decemberEventService: DecemberEventService,
) {
    fun run() {
        outputView.outputGreetingMessage()
        val reservationDay = inputReservationDay()
        val reservationOrders = inputReservationOrders()
        outputView.outputBenefitPreviewTitle(reservationDay.toString())
        outputView.outputOrders(reservationOrders.toString())
    }

    private fun inputReservationDay(): DecemberDay =
        retryOnException {
            val input = inputView.inputReservationDay()
            decemberEventService.getReservationDay(input)
        }

    private fun inputReservationOrders(): Orders =
        retryOnException {
            val input = inputView.inputReservationOrders()
            decemberEventService.getReservationOrders(input)
        }

    private fun <Return> retryOnException(operation: () -> Return): Return {
        return try {
            operation()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            retryOnException(operation)
        }
    }
}