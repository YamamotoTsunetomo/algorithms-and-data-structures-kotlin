package structures.queue

interface Queue<T> {
    fun enqueue(t: T): Boolean
    fun dequeue(): T?
    fun peek(): T?
    fun isEmpty(): Boolean
}