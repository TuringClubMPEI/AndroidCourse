interface Shop {
    fun sell(sellChairs: Int, sellTables: Int, sellCloset: Int)
}

class HomeFurniture(private val storage: Storage) : Shop {

    override fun sell(sellChairs: Int, sellTables: Int, sellCloset: Int) {
        storage.removeFurniture(sellTables, sellChairs, sellCloset)
    }

}
