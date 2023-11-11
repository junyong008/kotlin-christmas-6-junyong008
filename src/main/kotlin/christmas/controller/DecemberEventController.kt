package christmas.controller

import christmas.domain.DecemberDay
import christmas.domain.DecemberEvent
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
    }

    private fun inputReservationDay(): DecemberDay =
        retryOnException {
            val input = inputView.inputReservationDay()
            decemberEventService.getReservationDay(input)
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