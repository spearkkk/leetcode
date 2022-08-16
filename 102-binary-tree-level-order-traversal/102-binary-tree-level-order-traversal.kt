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
    private val result = Array<MutableList<Int>>(2001) { mutableListOf() }
    
    private fun probe(node: TreeNode?, level: Int) {
        if (node == null) {
            return
        }
        
        result[level].add(node.`val`)

        probe(node.left, level + 1)
        probe(node.right, level + 1)
    }
    
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        probe(root, 0)
        
        return result.filter { it.isNotEmpty() }
    }
}