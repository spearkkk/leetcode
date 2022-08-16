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
    private fun validate(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }

        if (left != null && right != null && left.`val` == right.`val`) {
            return validate(left.left, right.right) && validate(left.right, right.left)
        }

        return false
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return validate(root.left, root.right)
    }
}