import algorithms.string.validateBrackets

fun main() {
    val a = "(){}[]{}[]"
    val b = "(({}))"
    println("${a.validateBrackets()}  ${b.validateBrackets()}")
}