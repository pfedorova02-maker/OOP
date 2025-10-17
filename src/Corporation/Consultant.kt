package Corporation

import Corporation.Worker
import kotlin.random.Random

data class Consultant(
    override val name: String,
    override val age: Int = 0,
    override val id: Int,
    override val  salary: Int
): Worker(name = name, age = age, id = id, salary = salary, type = WorkerType.CONSULTANT), Cleaner{

    override fun copy(name: String, age: Int, id: Int, salary: Int, type: WorkerType): Accountant {
        return Accountant(name = name, age = age, id = id, salary = salary)
    }

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