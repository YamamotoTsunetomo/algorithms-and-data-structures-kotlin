package structures.list

interface List<T> {
    fun isEmpty(): Boolean
    fun push(info: T)
    fun append(info: T)
    fun nodeAt(index: Int): Node<T>?
    fun insert(info: T, afterNode: Node<T>): Node<T>
    fun pop(): T?
    fun removeLast(): T?
    fun removeAfter(node: Node<T>): T?
    fun clear()
    fun reverse()
}