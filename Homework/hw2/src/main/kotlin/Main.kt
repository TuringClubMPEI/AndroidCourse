fun main() {
    val agreeAnswer = "ДА"
    val localStorage = StorageOfHomeFurniture() //создаем объект склада
    localStorage.outputCurrentQuantity()
    println("LeMerlin: В пределах МКАД доставка - 450 рублей, за каждый километр от МКАДа добавляется 35 рублей")
    println("Ikea: В пределах МКАД доставка - 300 рублей, за каждый километр от МКАДа добавляется 70 рублей")
    println("Ваш склад расположен за пределами МКАД?")
    val answer = readln()
    var distance = 0
    if (answer.uppercase() == agreeAnswer) {
        println("Укажите расстояние до МКАДа:")
        distance = readln().toInt()
    }
    println("Сколько столов привезет 1-ый поставщик на склад?")
    var addNumberOfTables = readln().toInt()
    println("Сколько стульев привезет 1-ый поставщик на склад?")
    var addNumberOfChairs = readln().toInt()
    println("Сколько шкафов привезет 2-ый поставщик на склад?")
    var addNumberOfClosets = readln().toInt()
    val ikeaMoscow = IkeaRussia(addNumberOfChairs, addNumberOfTables) //создали объект первого поставщика
    println("Доставка от Ikea Moscow обойдется в ${ikeaMoscow.calcDeliveryCost(answer, distance)} рублей")
    val leMerlinMoscow = LeMerlinRussia(addNumberOfClosets)// создали объект второго поставщика
    println("Доставка от LeMerlinMoscow обойдется в ${leMerlinMoscow.calcDeliveryCost(answer, distance)} рублей")
    localStorage.addFurniture(
        ikeaMoscow.quantityOfTables,
        ikeaMoscow.quantityOfChairs,
        leMerlinMoscow.quantityOfClosets
    )
    localStorage.outputCurrentQuantity()
    val cozyHome = HomeFurniture(localStorage) //создаем объект магазина
    println("Сколько столов желаете приобрести?")
    val sellNumberOfTables = readln().toInt()
    println("Сколько стульев желаете приобрести?")
    val sellNumberOfChairs = readln().toInt()
    println("Сколько шкафов желаете приобрести?")
    val sellNumberOfClosets = readln().toInt()
    cozyHome.sell(sellNumberOfChairs, sellNumberOfTables, sellNumberOfClosets)
    localStorage.outputCurrentQuantity()
    println("Сколько столов привезет 1-ый поставщик на склад?")
    addNumberOfTables = readln().toInt()
    println("Сколько стульев привезет 1-ый поставщик на склад?")
    addNumberOfChairs = readln().toInt()
    println("Сколько шкафов привезет 2-ый поставщик на склад?")
    addNumberOfClosets = readln().toInt()
    localStorage.addFurniture(addNumberOfTables, addNumberOfChairs, addNumberOfClosets)
    localStorage.outputCurrentQuantity()
}
