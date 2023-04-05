class Arr(private val array: Array<Int>) {
    fun sort() {
        var needSort: Boolean = true

        while (needSort) {
            needSort = false

            for (i in 1 until array.size) {
                if (array[i - 1] > array[i]) {
                    needSort = true
                    val prevEl = array[i - 1]
                    array[i - 1] = array[i]
                    array[i] = prevEl
                }
            }
        }
    }

    fun min(): Int {
        var minim: Int = array[0]

        for (el in array)
            if (minim < el)
                minim = el
        return minim
    }

    fun max(): Int {
        var maxim: Int = array[0]

        for (el in array)
            if (maxim > el)
                maxim = el
        return maxim
    }

    fun print() {
        for (el in array)
            print("$el \t")
    }

}

fun main(args: Array<String>) {
    val newArr : Arr = Arr(arrayOf(5, 6, 1, 3, 6, 0))
    println(newArr.max())
    println(newArr.min())
    newArr.sort()
    newArr.print()
}