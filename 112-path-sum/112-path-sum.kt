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
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }

        val newTarget = targetSum - root.`val`
        
        if (root.left == null && root.right == null) {
            return newTarget == 0
        }
        
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget)
    }
}