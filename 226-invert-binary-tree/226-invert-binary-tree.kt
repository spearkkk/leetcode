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
     private fun change(head: TreeNode?): TreeNode? {
        if (head == null) {
            return null
        }

        val left = head.left
        val right = head.right

        head.left = change(right)
        head.right = change(left)
        return head
    }

    fun invertTree(root: TreeNode?): TreeNode? {
        return change(root)
    }
}