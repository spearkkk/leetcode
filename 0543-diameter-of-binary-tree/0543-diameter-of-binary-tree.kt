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
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        
        var max = 0
        
        fun dig(node: TreeNode?): Int {
            if (node == null) {
                return 0
            }
            
            val leftMaxDepth = dig(node.left)
            val rightMaxDepth = dig(node.right)
            
            max = Integer.max(max, leftMaxDepth + rightMaxDepth)
            return Integer.max(leftMaxDepth, rightMaxDepth) + 1
        }
        
        dig(root)
        return max
    }
}