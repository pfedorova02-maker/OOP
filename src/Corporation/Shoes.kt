package Corporation

class Shoes(nameClassShoes: String, priceClassShoes: Int, val size: Int):
    ProductCard(nameClass = nameClassShoes, priceClass = priceClassShoes, ProductType.SHOES) {

    override fun toString(): String {
        return ("Name: $nameClass Price: $priceClass Product Type ${productType.title} Power: $size\n")
    }
}