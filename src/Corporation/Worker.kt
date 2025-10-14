package Corporation

abstract class Worker(
    val name: String,
    val age: Int = 0,
    val id: Int
) {

    var salary: Int = 15000
        set(value) {
            if (value < field){
                println("The new salary is too small...")
            } else{
                field = value
            }
        }



//    private var salary: Int = 15000
//
//    fun setSalary(salary: Int) {
//        if (salary < this.salary) {
//            println("The new salary is too small...")
//        } else {
//            this.salary = salary
//        }
//    }
//
//    fun getSalary(): Int{
//        return this.salary
//    }

    override fun toString(): String {
        return "ID: $id, Name: $name, Age: $age, Salary: $salary"
    }

    abstract fun work()

    open fun printInfo() {
        println(this)

    }
}