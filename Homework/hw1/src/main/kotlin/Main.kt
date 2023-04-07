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

class ArrayTools(private val array: IntArray = intArrayOf()){
    fun findMin(): Int {
        var maxValue = array[0];
        for (i in array.drop(1)) {
            if (i < maxValue) {
                maxValue = i
            }
        }
        return maxValue
    }

    fun getValue(): IntArray {
        return array
    }
    fun findMax(): Int {
        var minValue = array[0];
        for (i in array.drop(1)) {
            if (i > minValue) {
                minValue = i
            }
        }
        return minValue
    }

    fun sort(){
        for (i in 0 until array.size - 1) {
            for (j in 0 until array.size - i - 1) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j + 1].also { array[j + 1] = array[j] }
                }
            }
        }
    }
}
