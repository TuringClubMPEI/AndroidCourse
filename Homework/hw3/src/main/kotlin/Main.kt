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
        else
            println(calculator.calculateValueOfExpression(expression))
    }
}