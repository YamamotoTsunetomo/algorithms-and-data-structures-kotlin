package structures.list

class DoublyLinkedList<T> : List<T> {
    private var head: DoublyLinkedNode<T>? = null
    private var tail: DoublyLinkedNode<T>? = null

    var size: Int = 0
        private set

    override fun isEmpty(): Boolean = size == 0

    override fun toString(): String =
        if (isEmpty())
            "[]"
        else "[${head.toString()}]"

    override fun push(info: T) {
        head = DoublyLinkedNode(info, head, null)
        head!!.next?.prev = head
        if (tail == null) tail = head
        size++
    }

    override fun append(info: T) {
        if (isEmpty()) {
            push(info)
            return
        }
        tail?.next = DoublyLinkedNode(
            info = info,
            prev = tail
        )

        tail = tail?.next
        size++
    }

    override fun getAt(index: Int): T? = getNodeAt(index)?.info

    private fun getNodeAt(index: Int): DoublyLinkedNode<T>? {
        if (index < 0 || index >= size)
            return null
        var tmp = if (index < size / 2) head else tail
        return if (index < size / 2) {
            var i = 0
            while (tmp != null && i < index) {
                tmp = tmp.next
                i++
            }
            tmp
        } else {
            var i = size - 1
            while (tmp != null && i > index) {
                tmp = tmp.prev
                i--
            }
            tmp
        }

    }

    override fun insert(info: T, afterNodeAt: Int) {
        val afterNode = getNodeAt(afterNodeAt)
        if (tail == afterNode) {
            append(info)
            return
        }
        val newNode = DoublyLinkedNode(info, afterNode?.next, afterNode)
        afterNode?.next = newNode
        newNode.next?.prev = newNode
        size++
    }

    override fun pop(): T? {
        if (!isEmpty()) size--
        val res = head?.info
        head = head?.next
        head?.prev = null
        if (isEmpty())
            tail = null
        return res
    }

    override fun removeLast(): T? {
        if (!isEmpty()) size--
        val res = tail?.info
        tail = tail?.prev
        tail?.next = null
        if (isEmpty())
            head = null
        return res
    }

    private fun remove(node: DoublyLinkedNode<T>?): T? {
        if (node == head) return pop()

        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev

        if (node == tail)
            tail = node?.prev

        if (!isEmpty()) size--

        return node?.info
    }

    override fun removeAt(nodeAt: Int): T? {
        if (nodeAt == 0) return pop()
        return remove(getNodeAt(nodeAt))
    }


    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun reverse() {
        var curr: DoublyLinkedNode<T>? = head
        var tmp: DoublyLinkedNode<T>? = null

        tail = DoublyLinkedNode(head?.info, null, head?.next)

        while (curr != null) {
            tmp = curr.prev
            curr.prev = curr.next
            curr.next = tmp
            curr = curr.prev
        }

        if (head != null)
            head = tmp?.prev
    }

}
