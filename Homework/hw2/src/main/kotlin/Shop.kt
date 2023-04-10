/**
 * Интерфейс для магазина, при помощи которого с ним можно взаимодействовать
 */
interface Shop {
    val storage: Storage

    fun buyFurniture(itemToBuy: String): String {
        return if (itemToBuy in storage.stockRoom) {
            storage.delFurniture(itemToBuy)
            "Успешно куплен предмет '$itemToBuy'"
        } else {
            "Покупка невозможна, товар '$itemToBuy' отсутствует на складе"
        }
    }

    fun getFurniture(): List<String> {
        return storage.getFurniture()
    }
}

class Ikea(st: Store) : Shop{
    override val storage = st
}




