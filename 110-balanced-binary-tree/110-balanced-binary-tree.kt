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
    private fun checkHeight(node: TreeNode?): Int {
        /// node 가 null 이면 높이를 비교할 수 없다.
        if (node == null) {
            return -1
        }

        /// 왼쪽 서브 트리의 높이를 체크했을 때, 높이 차이가 크면 오른쪽 서브 트리는 확인하지 않아도 된다.
        val leftHeight: Int = checkHeight(node.left)
        if (leftHeight == Int.MIN_VALUE) {
            return leftHeight
        }
        
        /// 왼쪽 서브 트리를 확인한 후, 오른쪽 서브 트리를 확인한다.
        val rightHeight: Int = checkHeight(node.right)
        if (rightHeight == Int.MIN_VALUE) {
            return rightHeight
        }

        /// 양쪽 서브 트리의 높이가 정상이면 그 높이를 비교한다.
        val diff = leftHeight - rightHeight
        /// 높이가 1 이상 차이가 나면 밸런스드 트리가 되지 않는다.
        if (kotlin.math.abs(diff) > 1) {
            return Int.MIN_VALUE
        }
        /// 높이가 1 차이가 나거나 같으면 제일 큰 높이를 반환한다. 
        return kotlin.math.max(leftHeight, rightHeight) + 1
    }

    fun isBalanced(root: TreeNode?): Boolean {
        return checkHeight(root) != Int.MIN_VALUE
    }
}
