package Corporation

import Corporation.Worker
import java.io.File

class Accountant(
    nameAccount: String,
    ageAccount: Int,
    idAccountant: Int
) : Worker(name = nameAccount, age = ageAccount, id = idAccountant), Cleaner, Supplier {

    private val fileProducts = File("product_cards.txt")
    private val fileWorkers = File("workers.txt")

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
                EnamOperationCode.EXIT -> break
                EnamOperationCode.REGISTER_NEW_ITEM -> createProductCard()
                EnamOperationCode.SHOW_ALL_ITEMS -> showAllItems()
                EnamOperationCode.DELETE_PRODUCT_CARD -> deleteProductCard()
                EnamOperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                EnamOperationCode.FIRE_AN_EMPLOYEE -> deleteWorkerType()
                EnamOperationCode.SHOW_ALL_EMPLOYEE -> showAllItemsWorker()
                EnamOperationCode.CHANGE_SALARY -> changeSalary()
            }
        }
    }

    private fun changeSalary(){

        print("Enter ID of worker for change salary: ")
        val id = readln().toInt()
        print("Enter new salary: ")
        val newSalary = readln().toInt()
        val cardsWorker: MutableList<Worker> = loadAllCardsWorker()
        fileWorkers.writeText("")
        for (card in cardsWorker){
            if (card.id == id){
                card.salary = newSalary
            }
            saveWorkerTypeToFile(card)
        }
    }

   private fun registerNewEmployee (){
        val workerTypes = WorkerType.entries
        print("Choose position")
        for ((index, type) in workerTypes.withIndex()){
            print("$index - ${type.title}")
            if (index < workerTypes.size){
                print(", ")
            }else{
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
        val card = when (workerType){
            WorkerType.DIRECTOR -> {
                Director(name, age, id)
            }
            WorkerType.ACCOUNTANT -> {
                Accountant(name, age, id)
            }
            WorkerType.ASSISTANT -> {
                Assistant(nameA = name, idA = id)
            }
            WorkerType.CONSULTANT -> {
                Consultant(name, age, id)
            }
        }
       card.salary = salary
        saveWorkerTypeToFile(card)
    }

     fun loadAllCardsWorker(): MutableList<Worker>{
        if (!fileWorkers.exists()) fileWorkers.createNewFile()
        val cardsWorker = mutableListOf<Worker>()
        val content = fileWorkers.readText().trim()

        if (content.isEmpty()){
            return cardsWorker
        }

        val cardsWorkerAsString = content.split("\n")
        for (card in cardsWorkerAsString){
            val properties = card.split("%")
            val name = properties[0]
            val age = properties[1].toInt()
            val id = properties[2].toInt()
            val salary: Int = properties[3].toInt()
            val type = properties.last()
            val workerType = WorkerType.valueOf(type)
            val workerCard = when(workerType){
                WorkerType.DIRECTOR -> {
                    Director(nameD = name, ageD = age, idD = id)
                }
                WorkerType.ACCOUNTANT -> {
                    Accountant(nameAccount = name, ageAccount = age, idAccountant = id)
                }
                WorkerType.ASSISTANT -> {
                    Assistant(nameA = name, idA = id)
                }
                WorkerType.CONSULTANT -> {
                    Consultant(nameC = name, ageC = age, idC = id)
                }
            }
            workerCard.salary = salary
            cardsWorker.add(workerCard)
        }
        return cardsWorker
    }

    private fun showAllItemsWorker(){
        val cards = loadAllCardsWorker()
        for (card in cards){
            card.printInfo()
        }
    }

    private fun deleteWorkerType(){
        val cardsWorker: MutableList<Worker> = loadAllCardsWorker()
        print("Enter ID of worker for delete: ")
        val id = readln().toInt()
        for ((index, card) in cardsWorker.withIndex()){
            if (card.id == id){
                cardsWorker.removeAt(index)
                break
            }
            }
            fileWorkers.writeText("")
            for (card in cardsWorker){
                saveWorkerTypeToFile(card)
        }
    }

    private fun saveWorkerTypeToFile (workerType: Worker){
        fileWorkers.appendText("${workerType.name}%${workerType.age}%${workerType.id}%${workerType.salary}%")
        when(workerType){
            is Director -> fileWorkers.appendText("DIRECTOR")
            is Accountant -> fileWorkers.appendText("ACCOUNTANT")
            is Assistant -> fileWorkers.appendText("ASSISTANT")
            is Consultant -> fileWorkers.appendText("CONSULTANT")
        }
        fileWorkers.appendText("\n")
    }

    private fun deleteProductCard() {
        val cards: MutableList<ProductCard> = loadAllCards()
        print("Enter name of card for delete: ")
        val name = readln()
        for ((index, card) in cards.withIndex()){
            if (card.nameClass == name){
                cards.removeAt(index)
                break
            }
        }
        fileProducts.writeText("")
        for (card in cards){
            saveProductCardToFile(card)
        }
    }

    private fun loadAllCards(): MutableList<ProductCard> {
        if (!fileProducts.exists()) fileProducts.createNewFile()
        val cards = mutableListOf<ProductCard>()// в угловых скобках указываб тип данных, который будет там хранится
        val content = fileProducts.readText().trim()

        if (content.isEmpty()){
            return cards
        }

        val cardsAsString = content.split("\n")
        for (card in cardsAsString) {
            val properties = card.split("%")
            val name = properties[0]
            val price = properties[1].toInt()
            val type = properties.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[2].toInt()
                    Products(name, price, caloric)
                }

                ProductType.APPLIENCE -> {
                    val power = properties[2].toInt()
                    HouseholdAppliances(name, price, power)
                }

                ProductType.SHOES -> {
                    val size = properties[2].toInt()
                    Shoes(name, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }


    private fun showAllItems() {
        val cards = loadAllCards()
        for (card in cards){
            card.printInfo()
        }
    }

    private fun saveProductCardToFile (productCard: ProductCard) {
        fileProducts.appendText("${productCard.nameClass}%${productCard.priceClass}%")// file это мой текстовый документ который я создала в начале
        when (productCard) {
            is Products -> {
                val caloric = productCard.calories
                fileProducts.appendText("$caloric%")
            }

            is Shoes -> {
                val size = productCard.size
                fileProducts.appendText("$size%")
            }

            is HouseholdAppliances -> {
                val power = productCard.power
                fileProducts.appendText("$power%")
            }
        }
        fileProducts.appendText("${productCard.productType}\n")
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
        saveProductCardToFile(card)
    }
}
//            0 -> {
//                print("Enter the calories: ")
//                val calories = readln().toInt()
//                Products(
//                    calories = calories,
//                    nameClassProduct = productName,
//                    priceClassProduct = productPrice
//                )
//            }
//
//            1 -> {
//                print("Enter the power: ")
//                val power = readln().toInt()
//                HouseholdAppliances(
//                    power = power,
//                    nameClassHouse = productName,
//                    priceClassHouse = productPrice
//                )
//            }
//
//
//            else -> {
//                print("Enter the size: ")
//                val size = readln().toInt()
//                Shoes(
//                    size = size,
//                    nameClassShoes = productName,
//                    priceClassShoes = productPrice
//                )
//            }
//
//        }
//        card.printInfo()
//    }