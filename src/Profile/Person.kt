package Profile

import Corporation.Worker

data class Person(
    val nameClass: String,
    val secondNameClass : String,
    val heightClass: Int,
    val weightClass: Int
) {

    open fun printInfo() {
        println(this)
    }



    val firstAndSecondName: String
        get() = "$nameClass $secondNameClass"

    var ageClass: Int = 18

        set(value) {
            if (value > field){
                field = value
            }else {
                println("The new ahe must be bigger than the old one")
            }
        }
        get(): Int {
            println("Its indecent to ask a person his age")
            return field
        }

    fun info() {
        println("Name: $nameClass Age: $ageClass Height: $heightClass Weight: $weightClass")
    }

    fun sayHello (){
        println("Hello! My name is $nameClass")
    }


}

