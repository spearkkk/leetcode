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
    private fun probe(node: TreeNode?, result: MutableList<Int>) {
        if (node != null) {
            result.add(node.`val`)
            probe(node.left, result)
            probe(node.right, result)
        }
    }
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        probe(root, result)
        return result
    }
}
