package Corporation

import javax.swing.text.Position

abstract class Worker(
    open val name: String,
    open val age: Int = 0,
    open val id: Int,
    open val salary: Int = 15000,
    val type: WorkerType
) {

    abstract fun copy(
        name: String = this.name,
        age: Int = this.age,
        id: Int = this.id,
        salary: Int = this.salary,
        type: WorkerType = this.type
    ): Worker

    abstract fun work()

    open fun printInfo() {
        println(this)

    }
}