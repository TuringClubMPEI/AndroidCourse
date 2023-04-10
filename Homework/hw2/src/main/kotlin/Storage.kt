/**
 * Интерфейс для склада
 * Магазин будет взаимодействовать со складом через этот интерфейс
 */
interface Storage {
    val stockRoom: MutableList<String>
    fun getFurniture(): MutableList<String> {
        return stockRoom
    }

    fun delFurniture(itemToDel: String){
        stockRoom.remove(itemToDel)
    }
}

class Store(st: MutableList<String>) : Storage{
    override val stockRoom = st
}

