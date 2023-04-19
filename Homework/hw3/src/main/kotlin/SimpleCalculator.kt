import java.lang.ArithmeticException
import java.util.NoSuchElementException

class SimpleCalculator : Executor {
    private val operations = mutableMapOf<Char, (Double, Double) -> Double>()


    override fun setOperation(sign: Char, operation: (a: Double, b: Double) -> Double) {
        operations[sign] = operation
    }

    override fun execute(sign: Char, a: Double, b: Double): Double {
        return operations[sign]!!.invoke(a, b)
    }

    fun isCorrect(operator: Char, b: Double): Boolean {
        return !((operator == '/') and (b == 0.0))
    }

    fun calculateValueOfExpression(expression: String): Double {
        try {
            val numbers = ArrayDeque(listOf<Double>())  // дек для чисел
            val operators = ArrayDeque(listOf<Char>())  // дек для операций
            val parsedExpression = parseExpression(expression)
            val priorityOfOperations = mapOf<Char, Int>('+' to 1, '-' to 1, '*' to 2, '/' to 2)
            for (i in parsedExpression) {
                if (i::class.simpleName == "Double") {
                    numbers.addLast(i as Double)
                } else {
                    if ((i == '(')) {
                        operators.addLast(i as Char)
                    } else if (i == ')') {
                        while (operators.last() != '(') {
                            val operator = operators.removeLast()
                            val b = numbers.removeLast()
                            val a = numbers.removeLast()
                            if (isCorrect(operator, b)) {
                                val t = execute(operator, a, b)
                                numbers.addLast(t)
                            } else throw ArithmeticException("Делить на ноль нельзя! Ну вообще говоря можно, если очень захочется, но это не наш случай :)")
                        }
                        operators.removeLast()
                    } else if (i !in priorityOfOperations) {
                        throw ArithmeticException("Операция $i не определена")
                    } else if (operators.isEmpty()) {
                        operators.addLast(i as Char)
                    } else if (priorityOfOperations[i]!! <= priorityOfOperations.getOrDefault(
                            operators.lastOrNull(),
                            -1
                        )
                    ) {
                        while (priorityOfOperations[i]!! <= priorityOfOperations.getOrDefault(
                                operators.lastOrNull(),
                                -1
                            )
                        ) {
                            val operator = operators.removeLast()
                            val b = numbers.removeLast()
                            val a = numbers.removeLast()
                            if (isCorrect(operator, b)) {
                                val t = execute(operator, a, b)
                                numbers.addLast(t)
                            } else throw ArithmeticException("Делить на ноль нельзя! Ну вообще говоря можно, если очень захочется, но это не наш случай :)")
                        }
                        operators.addLast(i as Char)
                    } else {
                        operators.addLast(i as Char)
                    }
                }
            }
            while (!operators.isEmpty()) {
                val operator = operators.removeLast()
                val b = numbers.removeLast()
                val a = numbers.removeLast()
                if (isCorrect(operator, b))
                    numbers.addLast(execute(operator, a, b))
                else
                    throw ArithmeticException("Делить на ноль нельзя! Ну вообще говоря можно, если очень захочется, но это не наш случай :)")
            }
            return numbers.removeLast()
        } catch (e: NoSuchElementException) {
            throw ArithmeticException("Некорректный формат выражения!")
        }
    }

    private fun parseExpression(expression: String): List<Any> {
        val result = mutableListOf<Any>()
        var i = 0
        while (i < expression.length) {
            if (expression[i].isDigit()) {
                var tmp = ""
                for (j in i until expression.length) {
                    if (expression[j].isDigit()) {
                        tmp += expression[j]
                        if (j == expression.length - 1) {
                            i = j + 1
                            result.add(tmp.toDouble())
                        }
                    } else {
                        i = j + 1
                        result.add(tmp.toDouble())
                        result.add(expression[j])
                        break
                    }
                }
            } else {
                result.add(expression[i])
                i++
            }
        }
        return result
    }

}