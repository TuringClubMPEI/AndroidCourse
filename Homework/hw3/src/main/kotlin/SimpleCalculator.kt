import java.beans.Expression
import java.io.IOException
import java.lang.ArithmeticException
import java.util.Stack
import java.lang.IllegalArgumentException

enum class AllCalculationException(val message: String) {
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

    fun checkExpression(expression: String): String {
        val rightBracketSubsequence = Stack<Char>()

        for ((i, el) in expression.withIndex()) {
            if (el == '+' || el == '-' || el == '/' || el == '*') {
                if (i == 0)
                    return AllCalculationException.exceptionFirstNotNumber.message
                if (!expression[i - 1].isDigit() && expression[i - 1] != ')')
                    return AllCalculationException.exceptionErrorBeforOperaion.message
                if (i == expression.length - 1)
                    return AllCalculationException.exceptionLastOperation.message
                if (!expression[i + 1].isDigit() && expression[i + 1] != '(')
                    return AllCalculationException.exceptionErrorAfterOperation.message
                if (el == '/' && expression[i + 1] == '0')
                    return AllCalculationException.exceptionNullDivide.message
            }
            if (el == ')') {
                if (rightBracketSubsequence.empty())
                    return AllCalculationException.exceptionWrongBracketSubsequence.message
                if (rightBracketSubsequence.peek() != '(')
                    return AllCalculationException.exceptionWrongBracketSubsequence.message
                if (rightBracketSubsequence.peek() == '(')
                    rightBracketSubsequence.pop()
                if (i == 0)
                    return AllCalculationException.exceptionCloseBracketOnFirstPosition.message
                if (i < expression.length - 1 && expression[i + 1] != '+' && expression[i + 1] != '-' && expression[i + 1] != '*' && expression[i + 1] != '/' && expression[i - 1] != ')' && expression[i - 1] != '(')
                    return AllCalculationException.exceptionErrorAfterCloseBracket.message
                if (i > 0 && !expression[i - 1].isDigit())
                    return AllCalculationException.exceptionNotNumberBeforeCloseBracket.message
            }
            if (el == '(') {
                rightBracketSubsequence.push(el)
                if (i > 0 && expression[i - 1] != '+' && expression[i - 1] != '-' && expression[i - 1] != '*' && expression[i - 1] != '/' && expression[i - 1] != ')' && expression[i - 1] != '(')
                    return AllCalculationException.exceptionErrorBeforeOpenBracket.message
                if (i == expression.length - 1)
                    return AllCalculationException.exceptionOpenBracketLast.message
                if (!expression[i + 1].isDigit())
                    return AllCalculationException.exceptionNotNumberAfterOpenBracket.message
            }
        }
        if (!rightBracketSubsequence.empty())
            return AllCalculationException.exceptionWrongBracketSubsequence.message
        return "Ok"
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
        var checkExpression = parser.checkExpression(expression)

        simpleCalculator.addOperation('+') { a, b -> a + b }
        simpleCalculator.addOperation('-') { a, b -> a - b }
        simpleCalculator.addOperation('*') { a, b -> a * b }
        simpleCalculator.addOperation('/') { a, b -> a / b }


        if (checkExpression == "Ok") {
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
                        throw ArithmeticException(AllCalculationException.exceptionNullDivide.message)
                    stack.push(simpleCalculator.execute(el, leftOperand, rightOperand))
                }
            }
        } else {
            if (checkExpression == AllCalculationException.exceptionNullDivide.message)
                throw ArithmeticException(checkExpression)
            throw IOException(checkExpression)
        }

        return stack.peek()
    }
}