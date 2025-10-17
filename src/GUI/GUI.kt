package GUI

import GUI.Rectangle

fun main() {
    val rectangle = Rectangle(length = 10, width = 4)
   println(rectangle.area)
    rectangle.width = 10
    println(rectangle.area)
}