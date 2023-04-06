fun main(args: Array<String>) {
    print("Введите целочисленный массив через пробел: ")
    val arr = readln().split(' ').map { it.toInt() }.toIntArray()
    val t = ArrayTools(arr)
    println("Исходный массив: " + arr.contentToString())
    println("Минимум: " + t.findMin())
    println("Максимум: " + t.findMax())

    val sortedArr = t.sortArr()
    println("Отсортированный массив: " + sortedArr.contentToString())
}

class ArrayTools(val x: IntArray = intArrayOf()){
    fun findMin(): Int {
        var res = x[0];
        for (i in x.drop(1))
            if (i < res)
                res = i
        return res
    }

    fun findMax(): Int {
        var res = x[0];
        for (i in x.drop(1))
            if (i > res)
                res = i
        return res
    }

    fun sortArr(): IntArray {
        val tmp = x.clone()
        for (i in 0 until tmp.size - 1)
            for (j in 0 until tmp.size - i - 1)
                if (tmp[j] > tmp[j + 1])
                    tmp[j] = tmp[j + 1].also { tmp[j + 1] = tmp[j] }
        return tmp
    }
}