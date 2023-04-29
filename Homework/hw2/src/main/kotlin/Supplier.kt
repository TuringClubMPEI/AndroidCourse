interface Supplier {
    fun calcDeliveryCost(answer: String, distance: Int)//расчет стоимости доставки
}


class IkeaRussia(
    val quantityOfChairs: Int, //кол-во доставляемых стульев
    val quantityOfTables: Int, //кол-во доставляемых столов
) : Supplier {


    override fun calcDeliveryCost(answer: String, distance: Int) {
        println("В пределах МКАД доставка - 300 рублей, за каждый километр от МКАДа добавляется 70 рублей")
        var finalCost = 300
        if (distance != 0) {
            finalCost += distance * 70
        }
        println("Итоговая стоимость: $finalCost")
    }
}

class LeMerlinRussia(
    val quantityOfClosets: Int
) : Supplier {
    override fun calcDeliveryCost(answer: String, distance: Int) {
        println("В пределах МКАД доставка - 450 рублей, за каждый километр от МКАДа добавляется 35 рублей")
        var finalCost = 450
        if (distance != 0) {
            finalCost += distance * 35
        }
        println("Итоговая стоимость: $finalCost")
    }
}
