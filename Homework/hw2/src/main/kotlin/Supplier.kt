interface Supplier {
    fun deliveryTimetable() {
        println("В будние дни доставка на склад совершается с 8:00 до 20:00\nВ выходные дни доставка осуществляется с 10:30 до 19:30")
    }

    fun bringFurniture()//функция завоза мебели на склад
    fun calcDeliveryCost()//расчет стоимости доставки
    fun outputFurniture() //вывод на экран информации о позициях на складе и количестве товаров
}

class IkeaRussia(
    //Поставщик с 2 видами мебели
    private val furnitureType1: String, //наименование позиций поставщика
    private val furnitureType2: String,
    private var quantityOfFurnitureType1: Int, //кол-во позиций первого вида мебели
    private var quantityOfFurnitureType2: Int, //кол-во позиций второго вида мебели
) : Supplier {
    fun getQuantity1() = quantityOfFurnitureType1
    fun getQuantity2() = quantityOfFurnitureType2
    fun getNameOfFurnitureType1() = furnitureType1
    fun getNameOfFurnitureType2() = furnitureType2
    override fun bringFurniture() {
        print("Сколько позиций $furnitureType1 привезем на склад?")
        quantityOfFurnitureType1 = readln().toInt()
        print("Сколько позиций $furnitureType2 привезем на склад?")
        quantityOfFurnitureType2 = readln().toInt()
    }

    override fun calcDeliveryCost() {
        println("В пределах МКАД доставка - 300 рублей, за каждый километр от МКАДа добавляется 70 рублей\nВаш склад за пределами МКАД?(ДА/НЕТ)")
        val answer = readln()
        var finalCost = 300
        if (answer.uppercase() == "ДА") {
            println("Укажите расстояние до МКАДа:")
            val distance = readln()
            finalCost += distance.toInt() * 70
        }
        println("Итоговая стоимость: $finalCost")
    }


    override fun outputFurniture() {
        println("Доставили на склад:\n$quantityOfFurnitureType1---$furnitureType1\n$quantityOfFurnitureType2---$furnitureType2")

    }

}

class LeMerlinRussia(
    private var furnitureType3: String, //наименование позиций поставщика
    private var quantityOfFurnitureType3: Int, //кол-во позиций первого вида мебели
) : Supplier {
    fun getQuantity3() = quantityOfFurnitureType3
    fun getNameOfFurnitureType3() = furnitureType3
    override fun bringFurniture() {
        print("Сколько позиций $furnitureType3 привезем на склад?")
        quantityOfFurnitureType3 = readln().toInt()
    }

    override fun calcDeliveryCost() {
        println("В пределах МКАД доставка - 450 рублей, за каждый километр от МКАДа добавляется 35 рублей\nВаш склад за пределами МКАД?(ДА/НЕТ)")
        val answer = readln()
        var finalCost = 450
        if (answer.uppercase() == "ДА") {
            println("Укажите расстояние до МКАДа:")
            val distance = readln()
            finalCost += distance.toInt() * 35
        }
        println("Итоговая стоимость: $finalCost")
    }


    override fun outputFurniture() {
        println("Доставили на склад:\n$quantityOfFurnitureType3---$furnitureType3")
    }

}
