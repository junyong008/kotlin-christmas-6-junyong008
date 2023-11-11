package christmas.controller

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
    }
}