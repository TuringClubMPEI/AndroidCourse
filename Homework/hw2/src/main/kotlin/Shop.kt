interface Shop {
    fun sell(chairsToSell: Int, tablesToSell: Int, closetsToSell: Int)
}

class HomeFurniture(private val storage: Storage) : Shop {

    override fun sell(chairsToSell: Int, tablesToSell: Int, closetsToSell: Int) {
        storage.removeFurniture(tablesToSell, chairsToSell, closetsToSell)
    }

}
