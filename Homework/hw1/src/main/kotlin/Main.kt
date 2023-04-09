class Problem(){
    val numbers = arrayOf(3, 2, 3, 4, -76, 123, 45, 23, -100)

    fun min(){
        var minpos =0
        for(i in numbers){
            if (i<i+1){
                minpos = i
            }
        }

        for(i in numbers){
            if (i<minpos){
                minpos = i
            }
        }
        println("Минимальное число = $minpos")
    }

    fun max(){
        var maxpos =0
        for(i in numbers){
            if (i>i+1){
                maxpos = i
            }
        }

        for(i in numbers){
            if (i>maxpos){
                maxpos = i
            }
        }
        println("Максимальное число = $maxpos")
    }
}

fun main() {

    val pusk = Problem()

    pusk.min()
    pusk.max()
}