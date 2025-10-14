package Corporation

import Corporation.Worker

class Director(
    nameD: String,
    ageD: Int,
    idD: Int
): Worker(name = nameD, age = ageD, id = idD), Supplier {
    override fun work (){
        println("I am drinking coffee!")
    }

    override fun buy() {
        println("My position is Director. I am buying now.")
    }

    fun takeCoffee (noName: Assistant){
       val drinkName = noName.bringCoffe()
        println("Thank you, ${noName.name}. The $drinkName is very tasty")
    }

    fun workConsultant (consultant: Consultant){
       val servedClientsCount = consultant.serveClient()
        println("Corporation.Consultant ${consultant.name} serve $servedClientsCount clients")
    }

}