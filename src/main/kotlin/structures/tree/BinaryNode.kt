package structures.tree

import structures.list.LinkedList
import kotlin.math.max

data class BinaryNode<T : Any>(
    var info: T? = null,
    var left: BinaryNode<T>? = null,
    var right: BinaryNode<T>? = null
) {
    val min: BinaryNode<T>
        get() = left?.min ?: this

    val max: BinaryNode<T>
        get() = right?.max ?: this

    override fun toString(): String = diagram(this)

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String = node?.let {
        if (it.left == null && it.right == null)
            "$root${it.info}\n"
        else diagram(it.right, "$top ", "$top┌─", "$top| ") +
                root + "${it.info}\n" +
                diagram(it.left, "$bottom| ", "$bottom└──", "$bottom ")
    } ?: "${root}null\n"

    fun traverseInOrder(visit: (T?) -> Unit) {
        left?.traverseInOrder(visit)
        visit(info)
        right?.traverseInOrder(visit)
    }

    fun traverseInOrderWithNull(visit: (T?) -> Unit) {
        left?.traverseInOrderWithNull(visit) ?: visit(null)
        visit(info)
        right?.traverseInOrderWithNull(visit) ?: visit(null)
    }

    fun traversePreOrder(visit: (T?) -> Unit) {
        visit(info)
        left?.traversePreOrder(visit)
        right?.traversePreOrder(visit)
    }

    fun traversePreOrderWithNull(visit: (T?) -> Unit) {
        visit(info)
        left?.traversePreOrderWithNull(visit) ?: visit(null)
        right?.traversePreOrderWithNull(visit) ?: visit(null)
    }

    fun traversePostOrder(visit: (T?) -> Unit) {
        left?.traversePostOrder(visit)
        right?.traversePostOrder(visit)
        visit(info)
    }

    fun traversePostOrderWithNull(visit: (T?) -> Unit) {
        left?.traversePostOrderWithNull(visit) ?: visit(null)
        right?.traversePostOrderWithNull(visit) ?: visit(null)
        visit(info)
    }


    fun serialize(node: BinaryNode<T>? = this): LinkedList<T?> {
        val res = LinkedList<T?>()
        node?.traversePostOrderWithNull { res.append(it) }
        return res
    }

    fun deserialize(list: LinkedList<T>): BinaryNode<T>? {
        list.reverse()
        val rootValue = list.pop() ?: return null

        val root = BinaryNode(info = rootValue)
        root.left = deserialize(list)
        root.right = deserialize(list)

        return root
    }


    fun height(node: BinaryNode<T>? = this): Int = node?.let {
        1 + max(height(left), height(right))
    } ?: 0
}