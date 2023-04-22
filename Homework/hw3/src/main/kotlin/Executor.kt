interface Executor {

    fun addOperation(name: Char, operation: (a: Double, b: Double) -> Double)

    fun execute(operation: Char, a: Double, b: Double): Double
}