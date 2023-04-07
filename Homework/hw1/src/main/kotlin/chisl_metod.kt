class chisl_metod (var numbers : IntArray)  {
    fun minim(): Int {
        var minimum = numbers[0]
        val sizeofnumbers = numbers.size-1
        for (i in 1..sizeofnumbers){
            if(numbers[i]<minimum) minimum = numbers[i]
        }
        return minimum
    }

    fun maxim(): Int {
        var maximum = numbers[0]
        val sizeofnumbers = numbers.size-1
        for (i in 1..sizeofnumbers){
            if(numbers[i]>maximum) maximum = numbers[i]
        }
        return maximum
    }

    fun sort() {
        val sizeofnumbers = numbers.size-1
        for (konec in sizeofnumbers downTo 1) {
            for (index in 0..konec) {
                if (numbers[index]>numbers[index+1]) {
                    val buffer = numbers[index]
                    numbers[index] = numbers[index+1]
                    numbers[index+1] = buffer
                }
            }
        }

    }

}