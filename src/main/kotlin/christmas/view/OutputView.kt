package christmas.view

class OutputView {

    fun outputGreetingMessage() = println(GREETING_MESSAGE)

    companion object {
        private const val GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
    }
}