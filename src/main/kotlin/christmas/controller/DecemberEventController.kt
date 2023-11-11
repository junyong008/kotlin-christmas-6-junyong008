package christmas.controller

import christmas.domain.DecemberDay
import christmas.domain.DecemberEvent
import christmas.domain.Money
import christmas.domain.Orders
import christmas.view.InputView
import christmas.view.OutputView

class DecemberEventController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val decemberEvent: DecemberEvent,
) {
    fun run() {
        outputView.outputGreetingMessage()
        val reservationDay = inputReservationDay()
        val reservationOrders = inputReservationOrders()
        outputView.outputBenefitPreviewTitle(reservationDay.toString())
        outputView.outputOrders(reservationOrders.toString())

        val totalOrderAmountBeforeDiscount = reservationOrders.getTotalOrderAmount()
        outputView.outputTotalOrderAmountBeforeDiscount(totalOrderAmountBeforeDiscount.toString())
        val freeGift = decemberEvent.getFreeGift(totalOrderAmountBeforeDiscount)
        if (freeGift != null) outputView.outputFreeGift(freeGift.toString()) else outputView.outputFreeGift("없음")
        val benefits = decemberEvent.getBenefits(reservationDay, reservationOrders)
        if (benefits != null) outputView.outputBenefits(benefits.toString()) else outputView.outputBenefits("없음")
        val totalBenefitAmount = benefits?.getTotalBenefitAmount()?: Money(0)
        outputView.outputTotalBenefitAmount(totalBenefitAmount.toString())
        val discountAmount = benefits?.getTotalDiscountAmount()?: Money(0)
        val discountedPaymentAmount = totalOrderAmountBeforeDiscount.plus(discountAmount)
        outputView.outputDiscountedPaymentAmount(discountedPaymentAmount.toString())
    }

    private fun inputReservationDay(): DecemberDay =
        retryOnException {
            val input = inputView.inputReservationDay()
            DecemberDay.fromString(input)
        }

    private fun inputReservationOrders(): Orders =
        retryOnException {
            val input = inputView.inputReservationOrders()
            Orders.fromString(input)
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