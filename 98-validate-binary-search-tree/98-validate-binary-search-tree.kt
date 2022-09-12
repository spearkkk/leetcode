class Solution {
    private val footprint = mutableSetOf<Int>()

    private fun probe(node: TreeNode?, start: Int, end: Int): Boolean {
        if (node == null) {
            return true
        }
        if (footprint.contains(node.`val`)) {
            return false
        }

        footprint.add(node.`val`)

        if (node.`val` > end || node.`val` < start) {
            return false
        }

        return probe(node.left, start, node.`val`) && probe(node.right, node.`val`, end)
    }

    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        return probe(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }
}