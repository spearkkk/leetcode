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
   private fun probe(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        
        val leftCount = probe(node.left)
        val rightCount = probe(node.right)
        
        return (if (leftCount > rightCount) leftCount else rightCount) + 1
    }
    fun maxDepth(root: TreeNode?): Int {
        return probe(root)
    }
}