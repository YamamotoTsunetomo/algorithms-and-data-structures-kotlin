package structures.list

data class Node<T>(
    var info: T,
    var next: Node<T>? = null
) {
    override fun toString(): String = next?.let {
        "$info -> ${next.toString()}"
    } ?: "$info"
}