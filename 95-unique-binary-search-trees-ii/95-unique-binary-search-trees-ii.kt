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
    private fun generate(from: Int, to: Int): List<TreeNode?> {
        /// 트리를 만들 수 없는 경우, null로 반환한다.
        if (from > to) {
            return arrayListOf(null)
        }

        val result = mutableListOf<TreeNode>()

        for (i in from .. to) {
            /// 각 인덱스 위치를 기점으로 해서 왼쪽, 오른쪽 서브 트리를 만든다.
            val leftNodes = generate(from, i - 1)
            val rightNodes = generate(i + 1, to)

            /// 왼쪽, 오른쪽 서브 트리를 만든 후, 모든 경우의 수를 다 결과로 저장한다.
            for (leftNode in leftNodes) {
                for (rightNode in rightNodes) {
                    val parentNode = TreeNode(i)

                    parentNode.left = leftNode
                    parentNode.right = rightNode

                    result.add(parentNode)
                }
            }
        }
        return result
    }

    fun generateTrees(n: Int): List<TreeNode?> {
        return generate(1, n)
    }
}
