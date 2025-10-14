package Corporation

import Corporation.Worker
import kotlin.random.Random

class Consultant(
    nameC: String,
    ageC: Int = 0,
    idC: Int
): Worker(name = nameC, age = ageC, id = idC), Cleaner{

    override fun clean() {
        println("My position is Consultant. I am cleaning workplace")
    }

    override fun work() {
        println("I am served clients!")
    }

    fun sayHelo() {
        if (age > 0) {
            print("Hello! My name is $name. My age is $age. ")
        } else {
            print("Hello! My name is $name.")
        }
    }

    fun serveClient(): Int {
        val count = Random.nextInt(0, 100)
        println("I served $count clients")
        return count
    }
}