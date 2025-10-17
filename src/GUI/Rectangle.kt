package GUI

class Rectangle(
    var length: Int = 0,
    var width: Int = 0
) {

    val area: Int
        get() {
            return length * width
        }

    constructor(size: Int) : this(size, size)

    fun draw() {
        repeat(width) {
            repeat(length) {
                print("* ")
            }
            print("\n")
        }
    }
}