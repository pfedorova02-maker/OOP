package GUI

class Rectangle(
    val length: Int = 0,
    val width: Int = 0
) {

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