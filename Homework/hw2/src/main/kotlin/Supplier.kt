/**
 * Интерфейс для поставщика
 * При помощи него поставщик взаимодействует со складом
 * Здесь можно определять только методы, общие для обоих поставщиков
 */
interface Supplier {

    fun getFurniture(): String

    fun addFurniture(itemToAdd: String): Boolean

}

class ParisSupplier(
    private val clientStorage: Storage,
    private val typesOfFurniture: List<String>,
    private val companyName: String
) : Supplier {
    override fun getFurniture(): String {
        return "$typesOfFurniture"
    }

    override fun addFurniture(itemToAdd: String): Boolean {
        return if (itemToAdd in typesOfFurniture) {
            clientStorage.addFurniture(itemToAdd)
            true
        } else false
    }

    override fun toString(): String {
        return "$companyName поставляет $typesOfFurniture"
    }

    fun addNamedFurniture(itemToAdd: String, name: String): Boolean {
        return if (itemToAdd in typesOfFurniture) {
            clientStorage.addFurniture("$itemToAdd для $name от компании $companyName")
            true
        } else false
    }

}

class MoscowSupplier(
    private val clientStorage: Storage,
    private val typesOfFurniture: List<String>,
    private val companyName: String
) : Supplier {
    override fun getFurniture(): String {
        return "$typesOfFurniture"
    }

    override fun addFurniture(itemToAdd: String): Boolean {
        return if (itemToAdd in typesOfFurniture) {
            clientStorage.addFurniture(itemToAdd)
            true
        } else false
    }

    override fun toString(): String {
        return "$companyName поставляет $typesOfFurniture"
    }
}