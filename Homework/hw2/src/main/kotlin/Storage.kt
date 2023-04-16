interface Storage {
    fun addFurniture(num1: Int, num2: Int, num3: Int)
    fun removeFurniture(num1: Int, num2: Int, num3: Int)
    fun outputCurrentQuantity(type1: String, type2: String, type3: String)

}

class StorageOfHomeFurniture : Storage {
    private var numberOfItem1: Int = 0
    private var numberOfItem2: Int = 0
    private var numberOfItem3: Int = 0
    override fun addFurniture(num1: Int, num2: Int, num3: Int) {
        numberOfItem1 += num1
        numberOfItem2 += num2
        numberOfItem3 += num3
    }

    override fun removeFurniture(num1: Int, num2: Int, num3: Int) {
        numberOfItem1 -= num1
        numberOfItem2 -= num2
        numberOfItem3 -= num3
    }

    override fun outputCurrentQuantity(type1: String, type2: String, type3: String) {
        println("На складе сейчас находятся:\n$numberOfItem1---$type1\n$numberOfItem2---$type2\n$numberOfItem3---$type3")
    }
}