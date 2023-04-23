import java.lang.Exception

fun main(args: Array<String>) {
    val calculator = SimpleCalculator()
    calculator.setOperation('+') { a, b -> a + b }
    calculator.setOperation('-') { a, b -> a - b }
    calculator.setOperation('*') { a, b -> a * b }
    calculator.setOperation('/') { a, b -> a / b }
        while (true) {
            println("Введите арифметическое выражение без пробелов/для выхода введите exit")
            val expression = readln()
            if (expression == "exit")
                break
            else {
                try {
                    println(calculator.calculateValueOfExpression(expression))
                }
                catch (e: Exception){
                    println(e.message)
                }
            }
        }
}
