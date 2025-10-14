package cats

class Cat(val name: String): CatsFamily() {
    fun playWithMouse(){
        println("I am play with mouse")
    }

    override fun eat(){
        println("I am eating Wiskas now!")
    }

}