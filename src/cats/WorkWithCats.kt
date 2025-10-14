package cats

fun main() {
    val cat = Cat("Alisa")
    val lion = Lion(pride = 5)
    val animals = listOf<CatsFamily>(cat, lion)
    for (animal in animals) {
        animal.eat()
    }
}