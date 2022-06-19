package structures.list

interface List<T> {
    fun isEmpty(): Boolean
    fun push(info: T)
    fun append(info: T)
    fun getAt(index: Int): T?
    fun insert(info: T, afterNodeAt: Int)
    fun pop(): T?
    fun removeLast(): T?
    fun removeAt(nodeAt: Int): T?
    fun clear()
    fun reverse()
}