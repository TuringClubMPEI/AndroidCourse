/**
 * Интерфейс для магазина, при помощи которого с ним можно взаимодействовать
 */
interface Shop {
    fun boughtFurniture(furnitureType: Int, furnitureCount: Int): String
    fun storageInfo()
}

class furnitureShop(private val storage: Storage) : Shop {

    override fun boughtFurniture(furnitureType: Int, furnitureCount: Int): String {
        if (storage.exportFurnitureFronStorage(furnitureType - 1, furnitureCount) == "Ok") {
            return "Bought successful"
        } else
            return "Bought unsuccessful: isn't so much furniture"
    }

    override fun storageInfo() {
        val info = storage.getFurnitureInfo()

        for (i in 0 until info.size) {
            val el = info[i]
            println("Furniture Type $i: $el")
        }
    }
}

