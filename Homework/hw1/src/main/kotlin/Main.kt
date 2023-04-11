fun main() {
    println("Домашнее задание №1:")
    val numbers: Array<Int> = arrayOf(29, 29, -10, 0, -200, 37, 7, -7, -11, -6)
    val sample = ArrayTools(numbers)
    print("Исходный массив: ")
    sample.output()
    sample.getMin()
    sample.getMax()
    sample.sort()
    print("Массив после сортировки:")
    sample.output()
}

class ArrayTools(private val arr: Array<Int>) {

    fun output() {
        for (i in arr) {
            print(" $i ")
        }
        println()
    }

    private fun min(): Int { //поиск минимального элемента
        var testValue: Int =
            arr[0]
        for (i in 1..arr.size - 1) {
            if (arr[i] <= testValue) {
                testValue = arr[i]
            }
        }
        return testValue
    }

    fun getMin() {
        val minimal: Int = min()
        println("Минимальное значение массива: $minimal ")

    }

    private fun max(): Int { // поиск максимального элемента
        var testValue: Int =
            arr[0]
        for (i in 1..arr.size - 1) {
            if (arr[i] >= testValue) {
                testValue = arr[i]
            }
        }
        return testValue
    }

    fun getMax() {
        val maximum: Int = max()
        println("Максимальное значение массива: $maximum")
    }

    fun sort() { //функция сортировки пузырьком

        var buff: Int
        for (i in 0..arr.size - 2) {
            for (j in 0..arr.size - 2 - i) {
                if (arr[j] > arr[j + 1]) {
                    buff = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = buff
                }
            }
        }
    }
}