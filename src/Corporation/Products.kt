package Corporation

class Products(nameClassProduct: String, priceClassProduct: Int, val calories: Int):
    ProductCard(nameClass = nameClassProduct, priceClass = priceClassProduct, ProductType.FOOD) {

    override fun toString(): String {
        return ("Name: $nameClass Price: $priceClass Product Type ${productType.title} Power: $calories\n")
    }
}
