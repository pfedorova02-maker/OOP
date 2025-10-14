package Profile

fun main() {
    print("Input 1st name: ")
    val name1 = readln()
    print("Input 2nd name: ")
    val name2 = readln()
    print("Input 1st age: ")
    val age1 = readln().toInt()
    print("Input 2nd age: ")
    val age2 = readln().toInt()
    print("Input 1st height: ")
    val height1 = readln().toInt()
    print("Input 2nd height: ")
    val height2 = readln().toInt()
    print("Input 1st weight: ")
    val weight1 = readln().toInt()
    print("Input 2nd weight: ")
    val weight2 = readln().toInt()
    val polya = Person(nameClass = name1, heightClass = height1, weightClass = weight1)
    val ilkham = Person(nameClass = name2, heightClass = height2, weightClass = weight2)

    polya.ageClass = age1
    ilkham.ageClass = age2

    polya.info()
    ilkham.info()

    polya.ageClass = 0
    ilkham.ageClass = 0
}