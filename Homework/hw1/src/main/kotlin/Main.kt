fun main() {
    println("Домашнее задание №1:")
    val mas: Array<Int> = arrayOf(9, 5 , -10, 0, -2, 7)
    val numbers: Array<Int> = arrayOf(29, 9, -10, 0, -200, 37, 7, -7, -11, -6)
    val sample = ArrayTools()
    sample.vivod(mas)
    sample.min(mas)
    sample.max(mas)
    sample.sortmax(numbers)
    print("\nМассив после сортировки:")
    sample.vivod(numbers)
}
class ArrayTools{
    fun vivod(mass: Array<Int>){
        print("Исходный массив: ")
        for (i in mass){
            print(" $mass ")
        }
    }
    fun min(mass: Array<Int>){ //поиск минимального элемента
        var minimum = mass[0]
        for (i in 1..mass.size-1){
            if (mass[i] <= minimum){
                minimum = mass[i]
            }
        }
    }

    fun max(mass: Array<Int>){ // поиск максимального элемента
        var maxim = mass[0]
        for (i in 1..mass.size-1){
            if (mass[i] >= maxim){
                maxim = mass[i]
            }
        }
    }

    fun sortmax(mass: Array<Int>) { //функция сортировки пузырьком

        var buff: Int
        for (i in 0..8) {
            for (j in 0..8 - i) {
                if (mass[j] > mass[j + 1]) {
                    buff = mass[j]
                    mass[j] = mass[j + 1]
                    mass[j + 1] = buff
                }
            }
        }
    }
}