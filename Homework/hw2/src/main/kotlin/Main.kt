/**
 * Создать здесь объекты магазина, склада и поставщиков.
 * Показать их взаимодействие
 */

fun main(args: Array<String>) {
    val store = Store(mutableListOf())
    val s1 = ParisSupplier(store, listOf("стул", "стол"), "Paris Company LTD")
    val s2 = MoscowSupplier(store, listOf("кресло"), "Moscow shit")
    val t = Ikea(store)

    if (s1.addFurniture("стул")) {
        println("Успешно поставлен товар на склад")
    } else println(s1.toString())

    if (s2.addFurniture("стул")) {
        println("Успешно поставлен товар на склад")
    } else println(s2.toString())

    if (s1.addNamedFurniture("стул", "Руслан")) {
        println("Успешно поставлен именной товар на склад")
    } else println(s1.toString())

    println(t.getFurniture())

    if (t.buyFurniture("стул для Руслан от компании Paris Company LTD")) {
        println("Успешная покупка")
    } else println("Товар отсутсвует на складе")

    println(t.getFurniture())
}
