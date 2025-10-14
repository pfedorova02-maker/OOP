package Corporation

enum class EnamOperationCode(val action: String) {

    EXIT("Exit"),
    REGISTER_NEW_ITEM("Register new item"),
    SHOW_ALL_ITEMS("Show all items"),
    DELETE_PRODUCT_CARD("Delete product card"),
    REGISTER_NEW_EMPLOYEE("Register new employee"),
    FIRE_AN_EMPLOYEE("Fire an employee"),
    SHOW_ALL_EMPLOYEE("Show all employees"),
    CHANGE_SALARY("Change salary")
}