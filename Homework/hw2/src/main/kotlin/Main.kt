/**
 * Создать здесь объекты магазина, склада и поставщиков.
 * Показать их взаимодействие
 */

fun main(args: Array<String>) {
    val store = Store(mutableListOf())
    val supplier1 = ParisSupplier(store, listOf("стул", "стол"), "Paris Company LTD")
    val supplier2 = MoscowSupplier(store, listOf("кресло"), "Moscow shit")
    val myShop = Ikea(store)

    if (supplier1.addFurniture("стул")) {
        println("Успешно поставлен товар на склад")
    } else println(supplier1.toString())

    if (supplier2.addFurniture("стул")) {
        println("Успешно поставлен товар на склад")
    } else println(supplier2.toString())

    if (supplier1.addNamedFurniture("стул", "Руслан")) {
        println("Успешно поставлен именной товар на склад")
    } else println(supplier1.toString())

    println(myShop.getFurniture())

    if (myShop.buyFurniture("стул для Руслан от компании Paris Company LTD")) {
        println("Успешная покупка")
    } else println("Товар отсутсвует на складе")

    println(myShop.getFurniture())
}
