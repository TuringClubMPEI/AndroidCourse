/**
 * Интерфейс для склада
 * Магазин будет взаимодействовать со складом через этот интерфейс
 */
interface Storage {
    fun getProductInfo(): Array<Int>
    fun putProduct(countProduct: Int, productType: Int)
    fun exportProductFromStorage(countProduct: Int, productType: Int): String
}

class FurnitureStorage : Storage {

    private val furniture = arrayOf(0, 0, 0)
    override fun getProductInfo(): Array<Int> = furniture

    override fun exportProductFromStorage(countProduct: Int, productType: Int): String {
        if (furniture[productType] >= countProduct) {
            furniture[productType] -= countProduct
            return Feedback.Ok.message
        } else
            return Feedback.Error.message

    }

    override fun putProduct(countProduct: Int, productType: Int) {
        furniture[productType] += countProduct
    }
}
