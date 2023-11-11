package christmas

import christmas.controller.DecemberEventController
import christmas.service.DecemberEventService
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val decemberEventService = DecemberEventService()

    val decemberEventController = DecemberEventController(inputView, outputView, decemberEventService)
    decemberEventController.run()
}