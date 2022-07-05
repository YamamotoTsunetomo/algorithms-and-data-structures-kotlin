package structures.tree

class BinarySearchTree<T : Comparable<T>> {

    var root: BinaryNode<T>? = null
        private set

    override fun toString(): String = root?.toString() ?: "empty tree"


    fun insert(value: T) {
        fun insert(
            node: BinaryNode<T>?,
            value: T
        ): BinaryNode<T> {
            node ?: return BinaryNode(info = value)
            if (value < node.info!!)
                node.left = insert(node.left, value)
            else node.right = insert(node.right, value)
            return node
        }
        root = insert(root, value)
    }


    fun contains(value: T): Boolean {
        var curr = root
        while (curr != null) {
            if (curr.info == value)
                return true
            curr = if (value < curr.info!!)
                curr.left
            else curr.right
        }
        return false
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(
        node: BinaryNode<T>?,
        value: T
    ): BinaryNode<T>? {
        node ?: return null

        when {
            value == node.info -> {
                if (node.left == null && node.right == null)
                    return null
                if (node.left == null)
                    return node.right
                if (node.right == null)
                    return node.left
                node.right?.min?.info?.let { node.info = it }
                node.right = remove(node.right, node.info!!)
            }
            value < node.info!! -> node.left = remove(node.left, value)
            else -> node.right = remove(node.right, value)

        }

        return node
    }
}