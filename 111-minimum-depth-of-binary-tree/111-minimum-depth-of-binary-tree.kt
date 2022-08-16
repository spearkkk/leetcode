/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    private fun getHeight(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        val leftHeight: Int = getHeight(node.left)
        val rightHeight: Int = getHeight(node.right)
        if (leftHeight == 0 && rightHeight == 0) {
            return 1
        }
        if (rightHeight == 0) {
            return leftHeight + 1
        }
        if (leftHeight == 0) {
            return rightHeight + 1
        }
        return leftHeight.coerceAtMost(rightHeight) + 1
    }

    fun minDepth(root: TreeNode?): Int {
        return getHeight(root)
    }
}
