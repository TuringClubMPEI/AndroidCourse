interface Supplier {
    fun calcDeliveryCost(answer: String, distance: Int): Int//расчет стоимости доставки
}


class IkeaRussia(
    val quantityOfChairs: Int, //кол-во доставляемых стульев
    val quantityOfTables: Int, //кол-во доставляемых столов
) : Supplier {


    override fun calcDeliveryCost(answer: String, distance: Int): Int {
        var finalCost = 300
        if (distance != 0) {
            finalCost += distance * 70
        }
        return finalCost
    }
}

class LeMerlinRussia(
    val quantityOfClosets: Int
) : Supplier {
    override fun calcDeliveryCost(answer: String, distance: Int): Int {
        var finalCost = 450
        if (distance != 0) {
            finalCost += distance * 35
        }
        return finalCost
    }
}
