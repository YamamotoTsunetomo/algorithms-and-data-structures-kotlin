package structures.stack

import structures.list.LinkedList

class LinkedListStack<T> : Stack<T> {
    private val stack = LinkedList<T>()

    override fun push(t: T) = stack.push(t)

    override fun pop(): T? = stack.pop()

    override fun peek(): T? = stack.getAt(0)

    override fun isEmpty(): Boolean = stack.isEmpty()

    override fun toString(): String =
        stack.toString()
}