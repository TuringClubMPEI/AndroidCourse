import java.beans.Expression
import java.io.IOException
import java.lang.ArithmeticException
import java.util.Stack
import java.lang.IllegalArgumentException

enum class Message(val message: String) {
    exceptionFirstNotNumber("Не может операция стоять на первом месте"),
    exceptionErrorBeforOperaion("Не может идти перед операцией что-то кроме числа и закрывающей скобки"),
    exceptionLastOperation("Не может операция идти последней"),
    exceptionErrorAfterOperation("Не может идти после операции что-то кроме числа и открывающей скобки"),
    exceptionNullDivide("Нельзя делить на нуль"),
    exceptionWrongBracketSubsequence("Неправильная скобочная последовательность"),
    exceptionCloseBracketOnFirstPosition("Не может закрывающая скобка стоять на первом месте"),
    exceptionNotNumberBeforeCloseBracket("Не может перед закрывающей скобкой стоять не цифра"),
    exceptionErrorAfterCloseBracket("После закрывающей скобки должна быть операция, либо другая скобка"),
    exceptionErrorBeforeOpenBracket("Не может перед открывающей скобки стоять не операция и не скобка"),
    exceptionOpenBracketLast("Не может открывающая скобка стоять последней"),
    exceptionNotNumberAfterOpenBracket("Не может после открывающей скобки стоять не цифра")
}

class SimpleCalculator : Executor {
    private val operations = mutableMapOf<Char, (Double, Double) -> Double>()
    override fun addOperation(name: Char, operation: (a: Double, b: Double) -> Double) {
        operations[name] = operation
    }

    override fun execute(operation: Char, a: Double, b: Double): Double = operations[operation]!!(a, b)

}

class Parser {
    private val priorityOperation = mutableMapOf<Char, Int>(Pair('+', 1), Pair('-', 1), Pair('*', 2), Pair('/', 2))
    private val operators = arrayOf('+', '-', '*', '/')

    fun checkExpression(expression: String) {
        val rightBracketSubsequence = Stack<Char>()

        for ((i, el) in expression.withIndex()) {
            if (el in operators) {
                when {
                    i == 0 -> throw IllegalArgumentException(Message.exceptionFirstNotNumber.message)
                    !expression[i - 1].isDigit() && expression[i - 1] != ')' -> throw IllegalArgumentException(
                        Message.exceptionErrorBeforOperaion.message
                    )

                    i == expression.length - 1 -> throw IllegalArgumentException(Message.exceptionLastOperation.message)
                    !expression[i + 1].isDigit() && expression[i + 1] != '(' -> throw IllegalArgumentException(
                        Message.exceptionErrorAfterOperation.message
                    )

                    el == '/' && expression[i + 1] == '0' -> throw ArithmeticException(Message.exceptionNullDivide.message)
                }
            }
            if (el == ')') {
                when {
                    rightBracketSubsequence.empty() -> throw IllegalArgumentException(Message.exceptionWrongBracketSubsequence.message)
                    rightBracketSubsequence.peek() != '(' -> throw IllegalArgumentException(Message.exceptionWrongBracketSubsequence.message)
                    rightBracketSubsequence.peek() == '(' -> rightBracketSubsequence.pop()
                    i == 0 -> throw IllegalArgumentException(Message.exceptionCloseBracketOnFirstPosition.message)
                    i < expression.length - 1 && expression[i - 1] !in operators && expression[i - 1] != ')' && expression[i - 1] != '(' -> throw IllegalArgumentException(
                        Message.exceptionErrorAfterCloseBracket.message
                    )

                    i > 0 && !expression[i - 1].isDigit() -> throw IllegalArgumentException(Message.exceptionNotNumberBeforeCloseBracket.message)
                }
            }
            if (el == '(') {
                rightBracketSubsequence.push(el)
                when {
                    i > 0 && expression[i - 1] !in operators && expression[i - 1] != ')' && expression[i - 1] != '(' -> throw IllegalArgumentException(
                        Message.exceptionErrorBeforeOpenBracket.message
                    )

                    i == expression.length - 1 -> throw IllegalArgumentException(Message.exceptionOpenBracketLast.message)
                    !expression[i + 1].isDigit() -> throw IllegalArgumentException(Message.exceptionNotNumberAfterOpenBracket.message)
                }

            }
        }
        if (!rightBracketSubsequence.empty())
            throw IllegalArgumentException(Message.exceptionWrongBracketSubsequence.message)
    }

    fun convertToPostfixState(expression: String): String {
        var postfixState = String()
        val stack = Stack<Char>()
        for (el in expression) {
            if (el.isDigit())
                postfixState += el
            else if (el == '(') {
                stack.push(el)
                postfixState += ' '
            } else if (el == ')') {
                postfixState += ' '
                while (stack.peek() != '(') {
                    postfixState += stack.peek()
                    stack.pop()
                }
                stack.pop()
            } else {
                postfixState += ' '
                while (!stack.empty() && stack.peek() != '(' && priorityOperation[stack.peek()]!! >= priorityOperation[el]!!) {
                    postfixState += stack.peek()
                    stack.pop()
                }
                stack.push(el)
            }
        }

        if (!stack.empty())
            postfixState += ' '

        while (!stack.empty()) {
            postfixState += stack.peek()
            stack.pop()
        }

        return postfixState
    }
}

class Calculator {
    fun executeExpression(expression: String): Double {
        val parser = Parser()
        val simpleCalculator = SimpleCalculator()
        val stack = Stack<Double>()
        var postfixExpression = String()
        var currNumber = 0.0
        var leftOperand = 0.0
        var rightOperand = 0.0
        parser.checkExpression(expression)

        simpleCalculator.addOperation('+') { a, b -> a + b }
        simpleCalculator.addOperation('-') { a, b -> a - b }
        simpleCalculator.addOperation('*') { a, b -> a * b }
        simpleCalculator.addOperation('/') { a, b -> a / b }

        postfixExpression = parser.convertToPostfixState(expression)
        for ((i, el) in postfixExpression.withIndex()) {
            if (el.isDigit()) {
                currNumber *= 10
                currNumber += el.toString().toInt()
            } else if (el == ' ') {
                if (i > 0 && postfixExpression[i - 1].isDigit()) {
                    stack.push(currNumber)
                    currNumber = 0.0
                }
            } else {
                rightOperand = stack.peek()
                stack.pop()
                leftOperand = stack.peek()
                stack.pop()
                if (rightOperand == 0.0 && el == '/')
                    throw ArithmeticException(Message.exceptionNullDivide.message)
                stack.push(simpleCalculator.execute(el, leftOperand, rightOperand))
            }
        }

        return stack.peek()
    }
}