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
    /// 메모이제이션
    private val holder = mutableMapOf<Int, List<TreeNode>>()


    fun allPossibleFBT(n: Int): List<TreeNode?> {
        val result = mutableListOf<TreeNode>()

        /// 짝수일 경우 만들 수 없다
        if (n % 2 == 0) {
            return emptyList()
        }

        if (n == 1) {
            return listOf(TreeNode(0))
        }

        if (holder.containsKey(n)) {
            return holder[n]!!
        }

        /**
         * 0부터 n-1까지 왼쪽 노드에 선택한다고 하자
         * 그러면 오른쪽 노드는 n에서 왼쪽 노드의 수를 빼고, root노드의 수를 뺀 것과 같다.
         */
        for (i in 0 until n) {
            for (left in allPossibleFBT(i)) {
                for (right in allPossibleFBT(n - i -1)) {
                    val parent = TreeNode(0)
                    parent.left = left
                    parent.right = right

                    result.add(parent)
                }
            }
        }

        holder[n] = result


        return result
    }
}