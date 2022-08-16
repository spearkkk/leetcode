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
    private fun probe(node: TreeNode, result: MutableList<Int>) {
        if (node.left != null) {
            probe(node.left!!, result)
        }
        
        result.add(node.`val`)
        
        if (node.right != null) {
            probe(node.right!!, result)
        }
    }
    
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) {
            return emptyList()
        }
        
        probe(root, result)
        return result
    }
}