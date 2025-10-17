package Corporation

import com.sun.source.tree.IfTree

fun main() {
    val director = WorkersRepository.findDirector()
        ?: throwDirector()
    director.printInfo()
}
fun throwDirector(): Nothing {
    throw IllegalArgumentException("Director is required for this program. Please add director")
}
