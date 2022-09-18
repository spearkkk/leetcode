class Solution {
    private fun doFlatten(node: TreeNode): TreeNode {
        if (node.left == null && node.right == null) {
            return node
        }

        val left = node.left
        node.left = null
        if (left == null) {
            return doFlatten(node.right!!)
        }
        val leftLeaf = doFlatten(left)

        val right = node.right
        node.right = left
        leftLeaf.right = right

        return if (right == null) leftLeaf else doFlatten(right)
    }

    fun flatten(root: TreeNode?): Unit {
        if (root != null) {
            doFlatten(root)
        }
    }
}