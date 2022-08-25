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
    private fun getValueFromRightLeave(cur: TreeNode?): Int {
        if (cur == null) {
            return 0
        }

        if (cur.left == null && cur.right == null) {
            return 0
        }
        return getValueFromLeftLeave(cur.left) + getValueFromRightLeave(cur.right)
    }

    private fun getValueFromLeftLeave(cur: TreeNode?): Int {
        if (cur == null) {
            return 0
        }
        if (cur.left == null && cur.right == null) {
            return cur.`val`
        }
        return getValueFromLeftLeave(cur.left) + getValueFromRightLeave(cur.right)
    }

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root != null) {
            return getValueFromLeftLeave(root.left) + getValueFromRightLeave(root.right)
        }
        return 0
    }
}