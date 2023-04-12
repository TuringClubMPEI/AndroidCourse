/**
 * Интерфейс для магазина, при помощи которого с ним можно взаимодействовать
 */
enum class Feedback(val message: String) {
    Ok("Ok"),
    Error("Error"),
    BoughtSuccessful("Bought Successful"),
    BoughtUnsuccessful("Bought Unsuccessful")
}

interface Shop {
    fun boughtProduct(productCount: Int, productType: Int): String
    fun storageInfo()
}

class FurnitureShop(private val storage: Storage) : Shop {

    override fun boughtProduct(productCount: Int, productType: Int): String {
        if (storage.exportProductFromStorage(productCount, productType - 1) == "Ok") {
            return Feedback.BoughtSuccessful.message
        } else
            return Feedback.BoughtUnsuccessful.message
    }

    override fun storageInfo() {
        val info = storage.getProductInfo()

        for ((i, el) in info.withIndex()) {
            println("Furniture Type $i: $el")
        }
    }
}

