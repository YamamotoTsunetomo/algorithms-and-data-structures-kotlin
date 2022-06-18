package structures.queue

import structures.list.LinkedList

class LinkedListQueue<T> : Queue<T> {
    private val queue = LinkedList<T>()

    override fun enqueue(t: T): Boolean {
        queue.append(t)
        return true
    }

    override fun peek(): T? = queue.nodeAt(0)?.info

    override fun dequeue(): T? = queue.pop()

    override fun isEmpty(): Boolean = queue.isEmpty()

    override fun toString(): String =
        queue.toString()
}