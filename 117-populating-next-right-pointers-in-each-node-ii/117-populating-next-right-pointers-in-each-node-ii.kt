class Solution {
    private fun doConnect(stack: MutableList<Node>) {
        if (stack.isEmpty()) {
            return
        }

        val nextStack = mutableListOf<Node>()
        var cursor: Node? = null
        while (stack.isNotEmpty()) {
            val nextNode = stack.removeAt(0)

            if (nextNode.left != null) nextStack.add(nextNode.left!!)
            if (nextNode.right != null) nextStack.add(nextNode.right!!)

            if (cursor != null) cursor.next = nextNode
            cursor = nextNode
        }
        doConnect(nextStack)
    }

    fun connect(root: Node?): Node? {
        if (root != null) doConnect(mutableListOf(root))
        return root
    }
}