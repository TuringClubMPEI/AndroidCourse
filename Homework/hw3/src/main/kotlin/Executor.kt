interface Executor {

    fun setOperation(sign: Char, operation: (a: Double, b: Double) -> Double)

    fun execute(sign: Char, a: Double, b: Double): Double?

}