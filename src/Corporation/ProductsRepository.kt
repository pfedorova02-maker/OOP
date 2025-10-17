package Corporation

import java.io.File

object ProductsRepository {

    private val fileProducts = File("product_cards.txt")
    private val _products = loadAllCards()
    val products: List<ProductCard>
        get() = _products.toList()

    fun createProductCard(productCard: ProductCard){
        _products.add(productCard)
    }

   private fun loadAllCards(): MutableSet<ProductCard> {
        if (!fileProducts.exists()) fileProducts.createNewFile()
        val cards = mutableSetOf<ProductCard>()// в угловых скобках указываб тип данных, который будет там хранится
        val content = fileProducts.readText().trim()

        if (content.isEmpty()){
            return cards
        }

        val cardsAsString = content.split("\n")
        for (card in cardsAsString) {
            val properties = card.split("%")
            val name = properties[0]
            val price = properties[1].toInt()
            val type = properties.last().trim()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[2].toInt()
                    Products(name, price, caloric)
                }

                ProductType.APPLIENCE -> {
                    val power = properties[2].toInt()
                    HouseholdAppliances(name, price, power)
                }

                ProductType.SHOES -> {
                    val size = properties[2].toInt()
                    Shoes(name, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (productCard in _products) {
            content.append("${productCard.nameClass}%${productCard.priceClass}%")// file это мой текстовый документ который я создала в начале
            when (productCard) {
                is Products -> {
                    val caloric = productCard.calories
                    content.append("$caloric%")
                }

                is Shoes -> {
                    val size = productCard.size
                    content.append("$size%")
                }

                is HouseholdAppliances -> {
                    val power = productCard.power
                    content.append("$power%")
                }
            }
            content.append("${productCard.productType}\n")
        }
        fileProducts.writeText(content.toString())
    }

    fun deleteProductCard(name: String) {
        for (card in _products){
            if (card.nameClass == name){
                _products.remove(card)
                break
            }
        }
    }
}