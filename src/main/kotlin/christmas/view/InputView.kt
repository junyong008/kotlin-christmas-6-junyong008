package christmas.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputReservationDay(): String {
        println(INPUT_RESERVATION_DAY)
        return Console.readLine()
    }

    companion object {
        private const val INPUT_RESERVATION_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
    }
}