interface Storage {
    fun addFurniture(addNumberTables: Int, addNumberChairs: Int, addNumberClosets: Int)
    fun removeFurniture(removeNumberTables: Int, removeNumberChairs: Int, removeNumberClosets: Int)
    fun outputCurrentQuantity()

}

class StorageOfHomeFurniture(
    private var numberOfTables: Int = 0,
    private var numberOfChairs: Int = 0,
    private var numberOfClosets: Int = 0
) : Storage {

    override fun addFurniture(addNumberTables: Int, addNumberChairs: Int, addNumberClosets: Int) {
        numberOfTables += addNumberTables
        numberOfChairs += addNumberChairs
        numberOfClosets += addNumberClosets
    }

    override fun removeFurniture(removeNumberTables: Int, removeNumberChairs: Int, removeNumberClosets: Int) {
        numberOfTables -= removeNumberTables
        numberOfChairs -= removeNumberChairs
        numberOfClosets -= removeNumberClosets
    }

    override fun outputCurrentQuantity() {
        println("На складе сейчас находятся:\n$numberOfTables---Столы\n$numberOfChairs---Стулья\n$numberOfClosets---Шкафы")
    }
}