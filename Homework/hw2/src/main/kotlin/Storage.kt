/**
 * Интерфейс для склада
 * Магазин будет взаимодействовать со складом через этот интерфейс
 */
interface Storage {
    fun getFurnitureInfo(): Array<Int>
    fun putFurniture(furnitureType: Int, countFurniture: Int)
    fun exportFurnitureFronStorage(furnitureType: Int, countFurniture: Int): String
}

class furnitureStorage : Storage {

    private var furniture: Array<Int> = arrayOf(0, 0, 0)
    override fun getFurnitureInfo(): Array<Int> {
        return furniture
    }

    override fun exportFurnitureFronStorage(furnitureType: Int, countFurniture: Int): String {
        if (furniture[furnitureType] >= countFurniture) {
            furniture[furnitureType] -= countFurniture
            return "Ok"
        } else {
            return "Error"
        }
    }

    override fun putFurniture(furnitureType: Int, countFurniture: Int) {
        furniture[furnitureType] += countFurniture
    }
}
