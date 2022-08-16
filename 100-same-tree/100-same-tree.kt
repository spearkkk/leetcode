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
            return validate(left.left, right.left) && validate(left.right, right.right)
        }

        return false
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return validate(p, q)
    }
}