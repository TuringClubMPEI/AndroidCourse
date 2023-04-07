fun main(args: Array<String>) {
    print("Введите целочисленный массив через пробел: ")
    val arr = readln().split(' ').map { it.toInt() }.toIntArray()
    val t = ArrayTools(arr.clone())
    println("Исходный массив: " + arr.contentToString())
    println("Минимум: " + t.findMin())
    println("Максимум: " + t.findMax())

    t.sort()
    println("Отсортированный массив: " + t.getValue().contentToString())
}

class ArrayTools(private val x: IntArray = intArrayOf()){
    fun findMin(): Int {
        var res = x[0];
        for (i in x.drop(1)) {
            if (i < res) {
                res = i
            }
        }
        return res
    }

    fun getValue(): IntArray {
        return x
    }
    fun findMax(): Int {
        var res = x[0];
        for (i in x.drop(1)) {
            if (i > res) {
                res = i
            }
        }
        return res
    }

    fun sort(){
        for (i in 0 until x.size - 1) {
            for (j in 0 until x.size - i - 1) {
                if (x[j] > x[j + 1]) {
                    x[j] = x[j + 1].also { x[j + 1] = x[j] }
                }
            }
        }
    }
}
