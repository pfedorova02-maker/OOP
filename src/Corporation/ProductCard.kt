package Corporation

abstract class ProductCard(
    open val nameClass: String,
    open val priceClass: Int,
    val productType: ProductType
) {



    fun printInfo(){
            println(this.toString())
        }
    }
