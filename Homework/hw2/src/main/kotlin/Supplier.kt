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
    fun putFurnitureIntoStorage(storage: Storage, furnitureType: Int, countFurniture: Int): String
    fun printNameSupplier()
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
    override fun printNameSupplier() {
        println(name)
    }

    override fun putFurnitureIntoStorage(storage: Storage, furnitureType: Int, countFurniture: Int): String {
        if ((furnitureType == 1 || furnitureType == 2) && countFurniture >= 0) {
            storage.putFurniture(furnitureType - 1, countFurniture)
            return "Putting Success"
        }
        else
            return "Putting Error"
    }
}

class KazanSupplier : Supplier {
    private val name = "Kazan Supplier"
    override fun printNameSupplier() {
        println(name)
    }

    override fun putFurnitureIntoStorage(storage: Storage, furnitureType: Int, countFurniture: Int): String {
        if (furnitureType == 3 && countFurniture >= 0) {
            storage.putFurniture(furnitureType - 1, countFurniture)
            return "Putting Success"
        }
        else
            return "Putting Error"
    }
}