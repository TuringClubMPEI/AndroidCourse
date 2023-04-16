fun main() {
    val ikeaWhiteDacha = IkeaRussia("Диван", "Стол", 5, 10) //создаем объект поставщика#1
    val leMerlinMoscow = LeMerlinRussia("Шкаф", 11)//создаем объект поставщика #2
    val localStorage = StorageOfHomeFurniture() //создаем объект склада
    localStorage.outputCurrentQuantity( //смотрим содержимое склада
        ikeaWhiteDacha.getNameOfFurnitureType1(),
        ikeaWhiteDacha.getNameOfFurnitureType2(),
        leMerlinMoscow.getNameOfFurnitureType3()
    )
    ikeaWhiteDacha.deliveryTimetable() //расписание доставки, метод-пустышка
    ikeaWhiteDacha.calcDeliveryCost() //расчет стоимости доставки
    ikeaWhiteDacha.outputFurniture() //инфо о доставке на склад

    leMerlinMoscow.deliveryTimetable() //расписание доставки, метод-пустышка
    leMerlinMoscow.calcDeliveryCost() //расчет стоимости доставки
    leMerlinMoscow.outputFurniture() //инфо о доставке на склад

    localStorage.addFurniture( //добавляем на склад мебель
        ikeaWhiteDacha.getQuantity1(), ikeaWhiteDacha.getQuantity2(), leMerlinMoscow.getQuantity3()
    )
    localStorage.outputCurrentQuantity( //смотрим содержимое склада
        ikeaWhiteDacha.getNameOfFurnitureType1(),
        ikeaWhiteDacha.getNameOfFurnitureType2(),
        leMerlinMoscow.getNameOfFurnitureType3()
    )
    val furnitureHouse = HomeFurniture() //создаем объект магазина
    furnitureHouse.sell() //продаем в магазине мебель
    localStorage.removeFurniture( //раз продали, то на складе стало меньше мебели, логично
        furnitureHouse.getSellNum1(), furnitureHouse.getSellNum2(), furnitureHouse.getSellNum3()
    )
    localStorage.outputCurrentQuantity(
        ikeaWhiteDacha.getNameOfFurnitureType1(),
        ikeaWhiteDacha.getNameOfFurnitureType2(),
        leMerlinMoscow.getNameOfFurnitureType3()
    )
    ikeaWhiteDacha.bringFurniture()
    leMerlinMoscow.bringFurniture()
    localStorage.addFurniture(
        ikeaWhiteDacha.getQuantity1(),
        ikeaWhiteDacha.getQuantity2(),
        leMerlinMoscow.getQuantity3()
    )
    localStorage.outputCurrentQuantity(
        ikeaWhiteDacha.getNameOfFurnitureType1(),
        ikeaWhiteDacha.getNameOfFurnitureType2(),
        leMerlinMoscow.getNameOfFurnitureType3()
    )
}
