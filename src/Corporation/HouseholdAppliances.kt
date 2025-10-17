package Corporation

data class HouseholdAppliances(
    override val nameClass: String,
    override val priceClass: Int,
    val power: Int
):
    ProductCard(
        nameClass = nameClass,
        priceClass = priceClass,
        ProductType.APPLIENCE
    )