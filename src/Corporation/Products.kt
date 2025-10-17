package Corporation

data class Products(
    override val nameClass: String,
    override val  priceClass: Int,
    val calories: Int
):
    ProductCard(
        nameClass = nameClass,
        priceClass = priceClass,
        ProductType.FOOD
    )