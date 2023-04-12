fun main() {
    println("Домашнее задание №1:")
    val numbers: Array<Int> = arrayOf(29, 29, -10, 0, -200, 37, 7, -7, -11, -6)
    val sample = ArrayTools(numbers)
    print("Исходный массив: ")
    sample.output()
    sample.outputMin()
    sample.outputMax()
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

    fun outputMin() {
        println("Минимальное значение массива: ${min()} ")

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

    fun outputMax() {
        println("Максимальное значение массива: ${max()}")
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