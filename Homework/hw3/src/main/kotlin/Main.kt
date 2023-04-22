fun main(args: Array<String>) {
    val calculator = Calculator()
    println(calculator.executeExpression("(15+17)/2+78-16"))
    println(calculator.executeExpression("6/2*(1+2)"))
}