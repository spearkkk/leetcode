class Solution {
    fun rob(root: TreeNode?): Int {
        fun tryRob(node: TreeNode?): Pair<Int, Int> {
            if (node == null) return Pair(0, 0)

            val left = tryRob(node.left)
            val right = tryRob(node.right)

            val first = kotlin.math.max(left.first, left.second) + kotlin.math.max(right.first, right.second)
            val second = node.`val` + left.first + right.first
            return Pair(first, second)
        }

        val result = tryRob(root)
        return kotlin.math.max(result.first, result.second)
    }
}