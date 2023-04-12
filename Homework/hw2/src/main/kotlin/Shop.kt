/**
 * Интерфейс для магазина, при помощи которого с ним можно взаимодействовать
 */
interface Shop {
    fun buyFurniture(itemToBuy: String): Boolean

    fun getFurniture(): String
}

class Ikea(private val store: Store) : Shop {
    override fun buyFurniture(itemToBuy: String): Boolean {
        return if (store.inStorage(itemToBuy)) {
            store.delFurniture(itemToBuy)
            true
        } else false
    }

    override fun getFurniture(): String {
        return store.getFurniture()
    }
}






