package Corporation

import Corporation.Worker

data class Director(
    override val name: String,
    override val age: Int,
    override val  id: Int,
    override val  salary: Int
): Worker(name = name, age = age, id = id, salary = salary, type = WorkerType.DIRECTOR), Supplier {
    override fun work (){
        println("I am drinking coffee!")
    }

    override fun copy(name: String, age: Int, id: Int, salary: Int, type: WorkerType): Accountant {
        return Accountant(name = name, age = age, id = id, salary = salary)
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