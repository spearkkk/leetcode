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
    private fun dig(node: TreeNode, holder: MutableMap<Int, Int>) {
        holder[node.`val`] = holder.getOrDefault(node.`val`, 0) + 1
        if (node.left != null) dig(node.left!!, holder)
        if (node.right != null) dig(node.right!!, holder)
    }

    fun findMode(root: TreeNode?): IntArray {
        if (root == null) {
            return intArrayOf()
        }

        val holder = mutableMapOf<Int, Int>()
        dig(root, holder)

        var max = 0
        var result = mutableListOf<Int>()

        for (i in holder) {
            if (max < i.value) {
                max = i.value
                result = mutableListOf(i.key)
                continue
            }

            if (max == i.value)
                result.add(i.key)
        }
        return result.toIntArray()
    }
}