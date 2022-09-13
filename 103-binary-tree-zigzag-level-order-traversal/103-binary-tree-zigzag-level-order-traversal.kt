class Solution {
    private fun add(node: TreeNode, direction: Boolean, stack: MutableList<TreeNode?>) {
        if (direction) {
            stack.add(node.left)
            stack.add(node.right)
        } else {
            stack.add(node.right)
            stack.add(node.left)
        }
    }

    private fun probe(stack: MutableList<TreeNode?>, direction: Boolean, result: MutableList<List<Int>>) {
        val nextStack = mutableListOf<TreeNode?>()
        val current = mutableListOf<Int>()
        while (stack.isNotEmpty()) {
            val elem = stack.removeAt(stack.size - 1) ?: continue

            add(elem, direction, nextStack)
            current.add(elem.`val`)
        }
        if (current.isNotEmpty()) {
            result.add(current)
        }
        if (nextStack.isNotEmpty()) {
            probe(nextStack, !direction, result)
        }
    }

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        probe(mutableListOf(root), true, result)
        return result
    }
}