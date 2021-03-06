package structures.list

class LinkedList<T> : List<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    var size: Int = 0
        private set

    override fun isEmpty() = size == 0

    override fun toString(): String =
        if (isEmpty())
            "[]"
        else "[${head.toString()}]"

    override fun push(info: T) {
        head = Node(info, head)
        if (tail == null)
            tail = head
        size++
    }

    override fun append(info: T) {
        if (isEmpty()) {
            push(info)
            return
        }
        tail?.next = Node(info)
        tail = tail?.next
        size++
    }

    override fun getAt(index: Int): T? = getNodeAt(index)?.info

    private fun getNodeAt(index: Int): Node<T>? {
        var tmp = head
        var i = 0
        while (tmp != null && i < index) {
            tmp = tmp.next
            i++
        }

        return tmp
    }

    override fun insert(info: T, afterNodeAt: Int) {
        val afterNode = getNodeAt(afterNodeAt)
        if (tail == afterNode) {
            append(info)
            return
        }
        val newNode = Node(info, afterNode?.next)
        afterNode?.next = newNode
        size++
    }

    override fun pop(): T? {
        if (!isEmpty()) size--
        val res = head?.info
        head = head?.next
        if (isEmpty())
            tail = null
        return res
    }

    override fun removeLast(): T? {
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

    private fun removeAfter(node: Node<T>?): T? {
        if (node == head) return pop()

        if (!isEmpty()) size--

        if (node?.next == tail)
            tail = node

        node?.next = node?.next?.next
        return node?.info
    }

    override fun removeAt(nodeAt: Int): T? {
        if (nodeAt == 0) return pop()
        return removeAfter(getNodeAt(nodeAt - 1))
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun reverse() {
        var curr: Node<T>? = head
        var prev: Node<T>? = null
        var next: Node<T>?

        tail = head

        while (curr != null) {
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
    }

}
