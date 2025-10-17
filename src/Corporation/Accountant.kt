package Corporation

import java.net.IDN

data class Accountant(
    override val name: String,
    override val age: Int,
    override val id: Int,
    override val salary: Int
) : Worker(
    name = name,
    age = age,
    id = id,
    salary = salary,
    type = WorkerType.ACCOUNTANT
), Cleaner, Supplier {

    override fun copy(name: String, age: Int, id: Int, salary: Int, type: WorkerType): Accountant {
        return Accountant(name = name, age = age, id = id, salary = salary)
    }

    private val workersRepository = WorkersRepository
    private val productsRepository = ProductsRepository

    override fun clean() {
        println("My position is Accountant. I am cleaning workplace")
    }

    override fun buy() {
        println("My position is Accountant. I am buying now.")
    }

    override fun work() {
        while (true) {
            val operationCodeEnam = EnamOperationCode.entries
            println("\nEnter the operation code: ")
            for ((index, type) in operationCodeEnam.withIndex()) {
                println("$index - ${type.action} ")
            }
            val operationIndex = readln().toInt()
            val operationCode = operationCodeEnam[operationIndex]
            when (operationCode) {
                EnamOperationCode.EXIT -> {
                    workersRepository.saveChanges()
                    productsRepository.saveChanges()
                    break
                }

                EnamOperationCode.REGISTER_NEW_ITEM -> createProductCard()
                EnamOperationCode.SHOW_ALL_ITEMS -> showAllItems()
                EnamOperationCode.DELETE_PRODUCT_CARD -> deleteProductCard()
                EnamOperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                EnamOperationCode.FIRE_AN_EMPLOYEE -> deleteWorkerType()
                EnamOperationCode.SHOW_ALL_EMPLOYEE -> showAllItemsWorker()
                EnamOperationCode.CHANGE_SALARY -> changeSalary()
                EnamOperationCode.CHANGE_AGE -> changeAge()
            }
        }
    }

    private fun changeAge(){
        print("Enter ID of worker for change age: ")
        val id = readln().toInt()
        print("Enter new age: ")
        val newAge = readln().toInt()
        workersRepository.changeAge(id, newAge)
    }

    private fun changeSalary() {

        print("Enter ID of worker for change salary: ")
        val id = readln().toInt()
        print("Enter new salary: ")
        val newSalary = readln().toInt()
        workersRepository.changeSalary(id, newSalary)
    }

    private fun registerNewEmployee() {
        val workerTypes = WorkerType.entries
        print("Choose position")
        for ((index, type) in workerTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < workerTypes.size) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val workerTypeIndex = readln().toInt()
        val workerType = workerTypes[workerTypeIndex]
        print("Enter id: ")
        val id = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter age: ")
        val age = readln().toInt()
        print("Enter salary: ")
        val salary = readln().toInt()
        val card = when (workerType) {
            WorkerType.DIRECTOR -> {
                Director(name, age, id, salary = salary)
            }

            WorkerType.ACCOUNTANT -> {
                Accountant(name, age, id, salary = salary)
            }

            WorkerType.ASSISTANT -> {
                Assistant(name = name, id = id, salary = salary)
            }

            WorkerType.CONSULTANT -> {
                Consultant(name, age, id, salary = salary)
            }
        }
        workersRepository.registerNewEmployee(card)
    }

    private fun showAllItemsWorker() {
        val cards = workersRepository.workers
        for (card in cards) {
            card.printInfo()
        }
    }

    private fun deleteWorkerType() {
        print("Enter ID of worker for delete: ")
        val id = readln().toInt()
        workersRepository.deleteWorkerType(id)
    }

    private fun deleteProductCard() {
        print("Enter name of card for delete: ")
        val name = readln()
        productsRepository.deleteProductCard(name)
    }

    private fun showAllItems() {
        val cards = productsRepository.products
        for (card in cards) {
            card.printInfo()
        }
    }


    private fun createProductCard() {
        val productTypes = ProductType.entries
        print("Enter the product type. ")
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title} ")
            if (index < productTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val productTypeIndex = readln().toInt()
        val productType = productTypes[productTypeIndex]
        print("Enter the product name: ")
        val productName = readln()

        print("Enter the product price: ")
        val productPrice = readln().toInt()

        val card = when (productType) {

            ProductType.FOOD -> {
                print("Enter the calories: ")
                val calories = readln().toInt()
                Products(productName, productPrice, calories)
            }

            ProductType.APPLIENCE -> {
                print("Enter the power: ")
                val power = readln().toInt()
                HouseholdAppliances(productName, productPrice, power)
            }

            ProductType.SHOES -> {
                print("Enter the size: ")
                val size = readln().toInt()
                Shoes(productName, productPrice, size)
            }
        }
        productsRepository.createProductCard(card)
    }
}
