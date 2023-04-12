/**
 * Интерфейс для поставщика
 * При помощи него поставщик взаимодействует со складом
 * Здесь можно определять только методы, общие для обоих поставщиков
 */
interface Supplier {

    /**
     * Пример метода, который может быть в интерфейсе поставщика
     * Нужно добавить еще несколько методов
     */
    fun getProduct(countProduct: Int, productType: Int): Int
    fun printNameSupplier()
    fun putProduct(countProduct: Array<Int>)
}

/**
 * Пример реализации для создания класса поставщика
 * class MoscowFurniture : Supplier {
 *     override fun getFurniture() {
 *     // написать специфическую реализацию
 *     }
 * }
 */

class MoscowSupplier : Supplier {
    private val name = "Moscow Supplier"
    private val product = arrayOf(0, 0)
    override fun printNameSupplier() {
        println(name)
    }

    override fun getProduct(countProduct: Int, productType: Int): Int {
        if (product[productType - 1] >= countProduct) {
            product[productType - 1] -= countProduct
            return countProduct
        }
        return 0
    }

    override fun putProduct(countProduct: Array<Int>) {
        for ((i, el) in countProduct.withIndex()) {
            product[i] += el
            if (i >= product.size)
                break
        }
    }
}

class KazanSupplier : Supplier {
    private val name = "Kazan Supplier"
    private val product = arrayOf(0)
    override fun printNameSupplier() {
        println(name)
    }

    override fun getProduct(countProduct: Int, productType: Int): Int {
        if (product[productType - 1] >= countProduct) {
            product[productType - 1] -= countProduct
            return countProduct
        }
        return 0
    }

    override fun putProduct(countProduct: Array<Int>) {
        for ((i, el) in countProduct.withIndex()) {
            product[i] += el
            if (i >= product.size)
                break
        }
    }
}