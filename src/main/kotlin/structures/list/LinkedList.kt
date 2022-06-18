package structures.list

class LinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    var size: Int = 0
        private set

    fun isEmpty() = size == 0

    override fun toString(): String =
        if (isEmpty())
            "[]"
        else "[${head.toString()}]"

    fun push(info: T) {
        head = Node(info, head)
        if (tail == null)
            tail = head
        size++
    }

    fun append(info: T) {
        if (isEmpty()) {
            push(info)
            return
        }
        tail?.next = Node(info)
        tail = tail?.next
        size++
    }

    fun nodeAt(index: Int): Node<T>? {
        var tmp = head
        var i = 0
        while (tmp != null && i < index) {
            tmp = tmp.next
            i++
        }

        return tmp
    }

    fun insert(info: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(info)
            return tail!!
        }
        val newNode = Node(info, afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val res = head?.info
        head = head?.next
        if (isEmpty())
            tail = null
        return res
    }

    fun removeLast(): T? {
        val head = head ?: return null
        if (head.next == null) return pop()
        size--
        var prev = head
        var current = head

        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
        return current.info
    }

    fun removeAfter(node: Node<T>): T? {
        val res = node.next?.info
        if (node.next == tail)
            tail = node
        if (node.next != null)
            size--
        node.next = node.next?.next
        return res
    }

    fun clear() {
        head = null
        tail = null
        size = 0
    }

    fun reverse() {
        var curr: Node<T>? = head
        var prev: Node<T>? = null
        var next: Node<T>?

        tail = head
        head = curr

        while (curr != null) {
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
    }

}