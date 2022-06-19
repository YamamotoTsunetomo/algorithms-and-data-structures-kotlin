package structures.queue

import structures.stack.LinkedListStack

class StackQueue<T> : Queue<T> {

    private val leftStack = LinkedListStack<T>()
    private val rightStack = LinkedListStack<T>()

    override fun enqueue(t: T): Boolean {
        rightStack.push(t)
        return true
    }

    override fun dequeue(): T? {
        if (leftStack.isEmpty())
            transferElements()
        return leftStack.pop()
    }

    override fun peek(): T? {
        if (leftStack.isEmpty())
            transferElements()
        return leftStack.peek()
    }

    override fun isEmpty(): Boolean = leftStack.isEmpty() && rightStack.isEmpty()

    private fun transferElements() {
        var next = rightStack.pop()
        while (next != null) {
            leftStack.push(next)
            next = rightStack.pop()
        }
    }
}