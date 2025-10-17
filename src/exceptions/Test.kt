package exceptions

fun main() {
//    try {
//        val a = readln().toInt()
//        val b = readln().toInt()
//        println(a / b)
//    } catch (exception: Throwable){
//        println("Common error")
//    }
//    println("After try - catch")
//


    try {
        val list = listOf<Int>(1, 2, 3)
        println(list[3])
    } catch (exception: ArrayIndexOutOfBoundsException){
        println("You are outside")
    }

}