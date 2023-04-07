class ArrayChange(private val numbers: IntArray) {
    fun findMinimum(): Int {
        var minimumOfNumbers = numbers[0]
        for (i in 1..numbers.size-1) {
            if (numbers[i] < minimumOfNumbers) {
                minimumOfNumbers = numbers[i]
            }
        }
        return minimumOfNumbers
    }

    fun findMaximum(): Int {
        var maximumOfNumbers = numbers[0]
        for (i in 1..numbers.size - 1) {
            if (numbers[i] > maximumOfNumbers) {
                maximumOfNumbers = numbers[i]
            }
        }
        return maximumOfNumbers
    }

    fun sort() {
        for (endOfNumbers in numbers.size-1 downTo 1) {
            for (index in 0..endOfNumbers) {
                if (numbers[index] > numbers[index + 1]) {
                    val buffer = numbers[index]
                    numbers[index] = numbers[index + 1]
                    numbers[index + 1] = buffer
                }
            }
        }

    }

}