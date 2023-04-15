/**
 * Создать здесь объекты магазина, склада и поставщиков.
 * Показать их взаимодействие
 */

fun main() {
    val ikeaWhiteDacha = IkeaRussia("Диван", "Стол", 5, 10)
    ikeaWhiteDacha.deliveryTimetable()
    ikeaWhiteDacha.deliveryCost()
    ikeaWhiteDacha.outputFurniture()
    ikeaWhiteDacha.getFurnitureType2()
    ikeaWhiteDacha.getFurnitureType1()
    ikeaWhiteDacha.getQuantityType1()
    ikeaWhiteDacha.getQuantityType2()
    val cozyRoom = LeMerlinRussia("dqdw","dqwdw",111,1111)
    cozyRoom.deliveryTimetable()
    cozyRoom.deliveryCost()
    cozyRoom.outputFurniture()
}
