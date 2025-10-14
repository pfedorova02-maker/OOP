package Corporation

import Corporation.Worker

class Assistant(
     nameA: String,
     idA: Int
) : Worker(nameA, 30, 1), Cleaner, Supplier{

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
