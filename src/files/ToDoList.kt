package files

import java.io.File

fun main() {

    while (true) {
        val task = File("task.txt")
        val operationCodeEnam = OperationCode.entries

        println("Enter a new item, Output List or 0 to exit: ")
        for ((index, type) in operationCodeEnam.withIndex()) {
            print("$index - ${type.title} ")
            if (index< operationCodeEnam.size - 1){
                print(", ")
            }else{
                print(": ")
            }
        }
        val operationIndex = readln().toInt()
        val operationCode = operationCodeEnam[operationIndex]
        when (operationCode) {
            OperationCode.EXIT -> break
            OperationCode.ADD_A_CASE -> {
                print("Add a case for the day: ")
                val case = readln()
                task.appendText("$case\n")
                val caseSplit = case.split("\n")
            }
            OperationCode.OUTPUT_LIST ->{
                val content = task.readText().trim()// удалить все ненужные пробелы и пустые строки
                val contentSplit = content.split("\n")
                for ((index, case) in contentSplit.withIndex()){
                    println("$index - $case")
                }
            }

        }
    }
}