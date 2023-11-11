package christmas.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputReservationDay(): String {
        println(INPUT_RESERVATION_DAY)
        return Console.readLine()
    }

    fun inputReservationOrders(): String {
        println(INPUT_RESERVATION_ORDERS)
        return Console.readLine()
    }

    companion object {
        private const val INPUT_RESERVATION_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
        private const val INPUT_RESERVATION_ORDERS = "주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
    }
}