package christmas.view

class OutputView {
    fun outputGreetingMessage() = println(GREETING_MESSAGE)
    fun outputBenefitPreviewTitle(day: String) = println(BENEFIT_PREVIEW_TITLE.format(day))

    companion object {
        private const val GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
        private const val BENEFIT_PREVIEW_TITLE = "12월 %s에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
    }
}