/**
 * Интерфейс для склада
 * Магазин будет взаимодействовать со складом через этот интерфейс
 */
interface Storage {
    fun getFurniture(): String

    fun inStorage(itemToCheck: String): Boolean

    fun delFurniture(itemToDel: String): Boolean

    fun addFurniture(itemToAdd: String)
}

class Store(private val stockRoom: MutableList<String>) : Storage {
    override fun getFurniture(): String {
        return "$stockRoom"
    }

    override fun inStorage(itemToCheck: String): Boolean {
        return itemToCheck in stockRoom
    }

    override fun delFurniture(itemToDel: String): Boolean {
        return if (itemToDel in stockRoom) {
            stockRoom.remove(itemToDel)
            true
        } else false
    }

    override fun addFurniture(itemToAdd: String) {
        stockRoom.add(itemToAdd)
    }
}

