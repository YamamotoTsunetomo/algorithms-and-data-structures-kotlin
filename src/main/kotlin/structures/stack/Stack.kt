package structures.stack

interface Stack<T> {
    fun push(t: T)
    fun pop(): T?
    fun peek(): T?
    fun isEmpty(): Boolean
}