fun main() {
    println("Домашнее задание №1:")
    val sample = Hw1()
    sample.min()
    sample.max()
    sample.sort_max()
}
class Hw1{
    fun min(){ //поиск минимального элемента
        val numbers: Array<Int> = arrayOf(9, 5 , -10, 0, -2, 7)
        print("Исходный массив: ")
        for (num in numbers){
            print(" $num ")
        }
        var minimum = numbers[0]
        for (i in 1..5){
            if (numbers[i] <= minimum){
                minimum = numbers[i]
            }
        }
        println("\nМинимальный элемент массива: $minimum")
    }

    fun max(){ // поиск максимального элемента
        val numbers: Array<Int> = arrayOf(29, 5 , -10, 37, -200, 0)
        print("Исходный массив: ")
        for (num in numbers){
            print(" $num ")
        }
        var maxim = numbers[0]
        for (i in 1..5){
            if (numbers[i] >= maxim){
                maxim = numbers[i]
            }
        }
        println("\nМаксимальный элемент массива: $maxim")
    }

    fun sort_max(){ //функция сортировки пузырьком
        val numbers: Array<Int> = arrayOf(29, 9 , -10, 0, -200, 37, 7, -7, -11, -6)
        print("Исходный массив: ")
        for (num in numbers){
            print(" $num ")
        }
        var buff :Int
        for(i in 0..8){
            for(j in 0..8-i)
                if (numbers[j] > numbers[j+1]){
                    buff = numbers[j]
                    numbers[j] = numbers[j+1]
                    numbers[j+1] = buff
                }
        }
        print("\nМассив после сортировки:")
        for (num in numbers){
            print(" $num ")
        }
    }
}


