package christmas.controller

import christmas.domain.*
import christmas.view.InputView
import christmas.view.OutputView

class DecemberEventController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val decemberEvent: DecemberEvent,
) {

    private lateinit var reservationDay: DecemberDay
    private lateinit var reservationOrders: Orders

    private var freeGift: Orders? = null
    private var benefits: Benefits? = null
    private var eventBadge = EventBadge.NOTHING
    private var totalOrderAmountBeforeDiscount = Money(0)
    private var totalBenefitAmount = Money(0)
    private var discountedPaymentAmount = Money(0)

    fun run() {
        outputView.outputGreetingMessage()
        getReservation()
        calculateBenefits()
        outputBenefits()
    }

    private fun getReservation() {
        reservationDay = inputReservationDay()
        reservationOrders = inputReservationOrders()
    }

    private fun calculateBenefits() {
        totalOrderAmountBeforeDiscount = reservationOrders.getTotalOrderAmount()
        discountedPaymentAmount = totalOrderAmountBeforeDiscount
        freeGift = decemberEvent.getFreeGift(totalOrderAmountBeforeDiscount)

        decemberEvent.getBenefits(reservationDay, reservationOrders)?.let {
            benefits = it
            totalBenefitAmount = it.getTotalBenefitAmount()
            val discountAmount = it.getTotalDiscountAmount()
            discountedPaymentAmount = totalOrderAmountBeforeDiscount.plus(discountAmount)
            eventBadge = EventBadge.getBadge(totalBenefitAmount)
        }
    }

    private fun outputBenefits() {
        outputView.run {
            outputBenefitPreviewTitle(reservationDay.toString())
            outputOrders(reservationOrders.toString())
            outputTotalOrderAmountBeforeDiscount(totalOrderAmountBeforeDiscount.toString())
            outputFreeGift(freeGift?.toString() ?: "없음")
            outputBenefits(benefits?.toString() ?: "없음")
            outputTotalBenefitAmount(totalBenefitAmount.toString())
            outputDiscountedPaymentAmount(discountedPaymentAmount.toString())
            outputEventBadge(eventBadge.toString())
        }
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