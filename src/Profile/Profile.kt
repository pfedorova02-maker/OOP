package Profile

import Corporation.Director
import Corporation.Worker

fun main() {
    val persons = mutableSetOf<Person>()
    val person1 = Person("Sasha", "Bublik", 171, 53)
    val person2 = Person("Sasha", "Bublik", 171, 53)
    val person3 = person1.copy(nameClass = "Masha")

    persons.add(person1)
    persons.add(person2)
    persons.add(person3)

    for (person in persons){
        person.printInfo()
    }
}