package Corporation

import java.io.File

object WorkersRepository {

    private val fileWorkers = File("_workers.txt")
    private val _workers = loadAllCardsWorker()
    val workers: List<Worker>
        get() = _workers.toList()

    fun findAssistant(): Assistant? {
        for (worker in _workers){
            if (worker is Assistant){
                return worker
            }
        }
        return null
    }

    fun findDirector(): Director? {
        for (worker in _workers){
            if (worker is Director){
                return worker
            }
        }
        return null
    }

    fun saveChanges(){
        val content = StringBuilder()
        for (worker in _workers){
           content.append("${worker.name}%${worker.age}%${worker.id}%${worker.salary}%${worker.type}\n")
        }
        fileWorkers.writeText(content.toString())
    }

    fun changeAge(id: Int, newAge: Int){
        for (worker in _workers){
            if (worker.id == id){
                val newWorker: Worker = worker.copy(age = newAge)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun changeSalary(id: Int, newSalary: Int) {
        for (worker in _workers) {
            if (worker.id == id) {
                val newSalary: Worker = worker.copy(salary = newSalary)
                _workers.remove(worker)
                _workers.add(newSalary)
                break
            }
        }
    }

    fun deleteWorkerType(id: Int) {
        for (worker: Worker in _workers) {
            if (worker.id == id) {
                _workers.remove(worker)
                break
            }
        }
    }

    fun registerNewEmployee(newWorker: Worker) {
        _workers.add(newWorker)
    }


    private fun loadAllCardsWorker(): MutableSet<Worker> {
        println("loadAllCardsWorker")
        if (!fileWorkers.exists()) fileWorkers.createNewFile()
        val cardsWorker = mutableSetOf<Worker>()
        val content = fileWorkers.readText().trim()

        if (content.isEmpty()) {
            return cardsWorker
        }

        val cardsWorkerAsString = content.split("\n")
        for (card in cardsWorkerAsString) {
            val properties = card.split("%")
            val name = properties[0]
            val age = properties[1].toInt()
            val id = properties[2].toInt()
            val salary: Int = properties[3].toInt()
            val type = properties.last().trim()
            val workerType = WorkerType.valueOf(type)
            val workerCard = when (workerType) {
                WorkerType.DIRECTOR -> {
                    Director(name = name, age = age, id = id, salary = salary)
                }

                WorkerType.ACCOUNTANT -> {
                    Accountant(name = name, age = age, id = id, salary = salary)
                }

                WorkerType.ASSISTANT -> {
                    Assistant(name = name, id = id, salary = salary)
                }

                WorkerType.CONSULTANT -> {
                    Consultant(name = name, age = age, id = id, salary = salary)
                }
            }
            cardsWorker.add(workerCard)
        }
        return cardsWorker
    }

}