package Profile

class Person(
    private val nameClass: String,
    private val heightClass: Int,
    private val weightClass: Int
) {

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

