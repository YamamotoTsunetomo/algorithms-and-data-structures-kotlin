package algorithms.string

import structures.stack.LinkedListStack

fun String.validateBrackets(): Boolean {
    val stack = LinkedListStack<Char>()

    for (char in this) {
        if (char in "({[") {
            stack.push(char)
            continue
        }

        if (stack.isEmpty())
            return false

        val check = stack.pop()!!
        when (char) {
            ')' -> if (check in "{[") return false
            '}' -> if (check in "([") return false
            ']' -> if (check in "{(") return false
        }
    }
    return stack.isEmpty()
}