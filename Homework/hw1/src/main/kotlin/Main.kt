import java.util.*


class Arraytools(var size: Int, var base: IntArray = IntArray(size)) {

    fun Input_array() {
        base.forEachIndexed { index, i ->
            println("Ввод ${index + 1}) элемента ")
            val scan = Scanner(System.`in`)
            val input = scan.nextInt()
            base[index] = input
        }
    }

    fun Search_min(): Int {
        var minValue = base[0]
        for (i in base.drop(1)) {
            if (i < minValue) {
                minValue = i
            }
        }
        return minValue
    }

    fun Search_max(): Int {
        var maxValue = base[0]
        for (i in base.drop(1)) {
            if (i > maxValue) {
                maxValue = i
            }
        }
        return maxValue
    }

    fun Sort_array() {
        for (i in 0 until base.size - 1) {
            for (j in 0 until base.size - i - 1) {
                if (base[j] > base[j + 1]) {
                    base[j] = base[j + 1].also { base[j + 1] = base[j] }
                }
            }
        }
    }

    fun Output_array() {
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

    Array.Input_array()
    println("Минимальное число массива ${Array.Search_min()}")
    println("Максимальное число массива ${Array.Search_max()}")

    println("Отсортированный массив ")
    Array.Sort_array()
    Array.Output_array()
}