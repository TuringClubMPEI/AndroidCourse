import java.util.*

class Arraytools(private val size: Int, private val base: IntArray = IntArray(size)) {

    fun inputArray() {
        base.forEachIndexed { index, i ->
            println("Ввод ${index + 1}) элемента ")
            val scan = Scanner(System.`in`)
            val input = scan.nextInt()
            base[index] = input
        }
    }

    fun searchMin(): Int {
        var minValue = base[0]
        for (i in base.drop(1)) {
            if (i < minValue) {
                minValue = i
            }
        }
        return minValue
    }

    fun searchMax(): Int {
        var maxValue = base[0]
        for (i in base.drop(1)) {
            if (i > maxValue) {
                maxValue = i
            }
        }
        return maxValue
    }

    fun sortArray() {
        for (i in 0 until base.size - 1) {
            for (j in 0 until base.size - i - 1) {
                if (base[j] > base[j + 1]) {
                    base[j] = base[j + 1].also { base[j + 1] = base[j] }
                }
            }
        }
    }

    fun outputArray() {
        for (number in base) {
            print("$number \t")
        }
    }
}

fun main() {
    println("Введите размер массива ")
    val scan = Scanner(System.`in`)
    val size_array = scan.nextInt() // для целых
    var Array = Arraytools(size_array)

    Array.inputArray()
    println("Минимальное число массива ${Array.searchMin()}")
    println("Максимальное число массива ${Array.searchMax()}")

    println("Отсортированный массив ")
    Array.sortArray()
    Array.outputArray()
}