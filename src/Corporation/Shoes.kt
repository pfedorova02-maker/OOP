package Corporation

data class Shoes(
    override val nameClass: String,
    override val priceClass: Int,
    val size: Int
):
    ProductCard(
        nameClass = nameClass,
        priceClass = priceClass,
        ProductType.SHOES
    )