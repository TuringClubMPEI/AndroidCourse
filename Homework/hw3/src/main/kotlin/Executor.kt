interface Executor {

    fun setOperation(operation: (a: Double, b: Double) -> Double)

    fun execute(a: Double, b: Double): Double
}