class Solution {
    private fun sum(node: TreeNode, cur: Int): Int {
        val newCur = cur * 10 + node.`val`

        if (node.left == null && node.right == null) {
            return newCur
        }

        val left = if (node.left == null) 0 else sum(node.left!!, newCur)
        val right = if (node.right == null) 0 else sum(node.right!!, newCur)

        return left + right
    }
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return sum(root, 0)
    }
}