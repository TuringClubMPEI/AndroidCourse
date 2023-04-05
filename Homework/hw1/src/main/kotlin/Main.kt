class ArrayUtils(private val array: Array<Int>) {
    fun sort() {
        var needSort = true

        while (needSort) {
            needSort = false

            for (i in 1 until array.size) {
                if (array[i - 1] > array[i]) {
                    needSort = true
                    val previousElement = array[i - 1]
                    array[i - 1] = array[i]
                    array[i] = previousElement
                }
            }
        }
    }

    fun min(): Int {
        var minmum = array[0]

        for (el in array)
            if (minmum < el)
                minmum = el
        return minmum
    }

    fun max(): Int {
        var maximum = array[0]

        for (el in array)
            if (maximum > el)
                maximum = el
        return maximum
    }

    fun print() {
        for (el in array) {
            print("$el \t")
        }
    }

}

fun main(args: Array<String>) {
    val newArr = ArrayUtils(arrayOf(5, 6, 1, 3, 6, 0))
    println(newArr.max())
    println(newArr.min())
    newArr.sort()
    newArr.print()
}