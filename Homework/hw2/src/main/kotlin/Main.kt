/**
 * Создать здесь объекты магазина, склада и поставщиков.
 * Показать их взаимодействие
 */

fun main(args: Array<String>) {
    val store = Store(mutableListOf())
    val s1 = Supplier1(listOf("Стул", "Стол"), "Поставщик 1", store)
    val s2 = Supplier2(listOf("Кресло"), "Поставщик 2", store)
    val i =  Ikea(store)

    s1.addFurniture("Кровать")  // Заполняем склад
    s1.addFurniture("Стул")
    s1.addFurniture("Стул")
    s1.addFurniture("Стул")
    s1.addFurniture("Стол")

    println(i.getFurniture()) // Выводим содержимое склада

    println(i.buyFurniture("Кровать")) // Покупка несуществующего товара
    println(i.buyFurniture("Стул")) // Покупка товара
    println(i.getFurniture()) // Выводим содержимое склада

    s2.addNamedFurniture("Руслан") // Добавляем именной товар
    println(i.getFurniture()) // Выводим содержимое склада

    println(i.buyFurniture("Кресло для Руслан от компании Поставщик 2")) // Покупаем именной товар
    println(i.getFurniture()) // Выводим содержимое склада
}
