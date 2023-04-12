/**
 * Создать здесь объекты магазина, склада и поставщиков.
 * Показать их взаимодействие
 */

fun main(args: Array<String>) {
    val storage: Storage = FurnitureStorage()
    val moscowSuppllier: Supplier = MoscowSupplier()
    val kazanSuppllier: Supplier = KazanSupplier()
    val shop: Shop = FurnitureShop(storage)

    moscowSuppllier.putProduct(arrayOf(100, 200))
    kazanSuppllier.putProduct(arrayOf(300))
    moscowSuppllier.printNameSupplier()
    kazanSuppllier.printNameSupplier()
    storage.putProduct(moscowSuppllier.getProduct(70, 1), 0)
    storage.putProduct(moscowSuppllier.getProduct(130, 2), 1)
    storage.putProduct(kazanSuppllier.getProduct(260, 1), 2)
    shop.storageInfo()
    shop.boughtProduct(60, 1)
    shop.boughtProduct(90, 2)
    shop.boughtProduct(190, 3)
    shop.storageInfo()
}
