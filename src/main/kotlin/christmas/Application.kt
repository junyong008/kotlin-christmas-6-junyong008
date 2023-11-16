package christmas

import christmas.controller.DecemberEventController
import christmas.domain.DecemberEvent
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val decemberEvent = DecemberEvent()

    val decemberEventController = DecemberEventController(inputView, outputView, decemberEvent)
    decemberEventController.run()
}