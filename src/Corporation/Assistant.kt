package Corporation

import Corporation.Worker

data class Assistant(
     override val name: String,
     override val id: Int,
     override val age: Int = 0,
     override val salary: Int
) : Worker(
    name = name,
    age = age,
    id = id,
    salary = salary,
    type = WorkerType.ASSISTANT
), Cleaner, Supplier{

    override fun copy(name: String, age: Int, id: Int, salary: Int, type: WorkerType): Accountant {
        return Accountant(name = name, age = age, id = id, salary = salary)
    }

    override fun clean() {
        println("My position is Assistant. I am cleaning workplace")
    }

    override fun buy() {
        println("My position is Assistant. I am buying now.")
    }

    override fun work() {
        println("I am making coffee!")
    }

    fun bringCoffe(coffee: String = "Cappuchino", count: Int = 1): String {
        repeat(count){
            println("I'm going to the coffee machine")
            println("I press the button to make \"$coffee\"")
            println("I take the finished coffee and carry it to the director.")
            println("I leave his coffee and go to my work place.")
        }
        return coffee
        }
    }
