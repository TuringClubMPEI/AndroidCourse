fun main() {
    println("Домашнее задание №1:")
    val numbers: Array<Int> = arrayOf(29, 29, -10, 0, -200, 37, 7, -7, -11, -6)
    val sample = ArrayTools(numbers)
    print("Исходный массив: ")
    sample.vivod()
    sample.min()
    sample.get_min()
    sample.max()
    sample.get_max()
    sample.sort()
    print("Массив после сортировки:")
    sample.vivod()
}

class ArrayTools(num: Array<Int>) {
    private val mas: Array<Int> = num
    private var test_znach: Int =
        mas[0] //инициализируем переменную, которая служит мин./макс. значением в соответсвующих функциях

    fun vivod() {
        for (i in mas) {
            print(" $i ")
        }
        println()
    }

    fun min() { //поиск минимального элемента
        for (i in 1..mas.size - 1) {
            if (mas[i] <= test_znach) {
                test_znach = mas[i]
            }
        }
    }

    fun get_min() {
        println("Минимальное значение массива: $test_znach")
    }

    fun max() { // поиск максимального элемента
        for (i in 1..mas.size - 1) {
            if (mas[i] >= test_znach) {
                test_znach = mas[i]
            }
        }
    }

    fun get_max() {
        println("Максимальное значение массива: $test_znach")
    }

    fun sort() { //функция сортировки пузырьком

        var buff: Int
        for (i in 0..8) {
            for (j in 0..8 - i) {
                if (mas[j] > mas[j + 1]) {
                    buff = mas[j]
                    mas[j] = mas[j + 1]
                    mas[j + 1] = buff
                }
            }
        }
    }
}