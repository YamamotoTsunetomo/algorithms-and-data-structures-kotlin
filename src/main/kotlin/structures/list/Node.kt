package structures.list

data class Node<T>(
    var info: T?,
    var next: Node<T>? = null
) {
    override fun toString(): String = next?.let {
        "$info -> ${next.toString()}"
    } ?: "$info"
}

data class DoublyLinkedNode<T>(
    var info: T?,
    var next: DoublyLinkedNode<T>? = null,
    var prev: DoublyLinkedNode<T>? = null
) {
    override fun toString(): String = next?.let {
        "$info <-> ${next.toString()}"
    } ?: "$info"
}