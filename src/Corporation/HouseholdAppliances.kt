package Corporation

class HouseholdAppliances(nameClassHouse: String, priceClassHouse: Int, val power: Int):
    ProductCard(nameClass = nameClassHouse, priceClass = priceClassHouse, ProductType.APPLIENCE) {

    override fun toString(): String {
        return ("Name: $nameClass Price: $priceClass Product Type ${productType.title} Power: $power\n")
    }
}