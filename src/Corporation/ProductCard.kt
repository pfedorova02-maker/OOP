package Corporation

abstract class ProductCard(
    val nameClass: String,
    val priceClass: Int,
    val productType: ProductType
) {


    fun printInfo(){
            print(this.toString())
        }
    }
