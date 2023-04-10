/**
 * Создать здесь объекты магазина, склада и поставщиков.
 * Показать их взаимодействие
 */

fun main(args: Array<String>) {
    val storage: Storage = furnitureStorage()
    val suppl1 : Supplier = MoscowSupplier()
    val suppl2 : Supplier = KazanSupplier()
    val shop : Shop = furnitureShop(storage)

    println(suppl1.putFurnitureIntoStorage(storage, 1, 100))
    println(suppl1.putFurnitureIntoStorage(storage, 2, 50))
    println(suppl2.putFurnitureIntoStorage(storage, 3, 200))
    suppl1.printNameSupplier()
    suppl2.printNameSupplier()
    shop.storageInfo()
    println(shop.boughtFurniture(2, 30))
    println(shop.boughtFurniture(3, 230))
    shop.storageInfo()
}
