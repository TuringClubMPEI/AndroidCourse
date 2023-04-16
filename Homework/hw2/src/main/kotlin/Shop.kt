interface Shop {
    fun sell()

}

class HomeFurniture : Shop {
    private var sellNumber1: Int = 0
    private var sellNumber2: Int = 0
    private var sellNumber3: Int = 0
    fun getSellNum1() = sellNumber1
    fun getSellNum2() = sellNumber2
    fun getSellNum3() = sellNumber3

    override fun sell() {
        print("Укажите количество товара, которое хотите купить\nДиван: ")
        sellNumber1 = readln().toInt()
        println("Стол:")
        sellNumber2 = readln().toInt()
        println("Шкаф:")
        sellNumber3 = readln().toInt()
    }

}
