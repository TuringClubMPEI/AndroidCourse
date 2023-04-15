/**
 * Интерфейс для поставщика
 * При помощи него поставщик взаимодействует со складом
 * Здесь можно определять только методы, общие для обоих поставщиков
 */
interface Supplier {
    var furnitureType1: String //наименование позиций поставщика
    var furnitureType2: String
    var quantityOfFurnitureType1: Int //кол-во позиций первого вида мебели
    var quantityOfFurnitureType2: Int //кол-во позиций второго вида мебели
    fun deliveryTimetable() {
        println("В будние дни доставка на склад совершается с 8:00 до 20:00\nВ выходные дни доставка осуществляется с 10:30 до 19:30")
    }

    fun deliveryCost()
    fun getFurnitureType1(): String { //возврат наименований
        return furnitureType1
    }

    fun getFurnitureType2(): String { //возврат наименований
        return furnitureType2
    }

    fun getQuantityType1(): Int { //возврат кол-ва позиций
        return quantityOfFurnitureType1
    }

    fun getQuantityType2(): Int { //возврат кол-ва позиций
        return quantityOfFurnitureType2
    }

    fun outputFurniture() //вывод на экран информации о позициях на складе и количестве товаров
}

class IkeaRussia( //Поставщик с 2 видами мебели
    override var furnitureType1: String,
    override var furnitureType2: String, override var quantityOfFurnitureType1: Int,
    override var quantityOfFurnitureType2: Int
) : Supplier {

    override fun deliveryCost() {
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
        print("Доставили на склад:\n${getQuantityType1()}---${getFurnitureType1()}\n${getQuantityType2()}---${getFurnitureType2()}")
        //print("Доставили на склад:\n$quantityOfFurnitureType1---$furnitureType1\n$quantityOfFurnitureType2---$furnitureType2")
    }

}

class LeMerlinRussia(override var furnitureType1: String,
                     override var furnitureType2: String, override var quantityOfFurnitureType1: Int,
                     override var quantityOfFurnitureType2: Int) : Supplier {
    override fun deliveryCost() {
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
        print("Доставили на склад:\n${getQuantityType1()}---${getFurnitureType1()}\n")
    }

}
