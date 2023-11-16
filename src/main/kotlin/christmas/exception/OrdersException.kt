package christmas.exception

enum class OrdersException(val message: String) {
    INVALID("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    EXCEED_MAX_MENU_COUNT("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요."),
    ONLY_BEVERAGE("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요.")
}