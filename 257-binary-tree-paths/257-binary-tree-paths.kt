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
    private fun probe(parent: TreeNode, path: String, result: MutableList<String>) {
        if (parent.left == null && parent.right == null) {
            result.add(path)
        }

        if (parent.left != null) {
            probe(parent.left!!, "$path->${parent.left!!.`val`}", result)
        }

        if (parent.right != null) {
            probe(parent.right!!, "$path->${parent.right!!.`val`}", result)
        }
    }

    fun binaryTreePaths(root: TreeNode?): List<String> {
        if (root == null) {
            return emptyList()
        }
        val result = mutableListOf<String>()
        probe(root, "${root.`val`}", result)
        return result
    }
}