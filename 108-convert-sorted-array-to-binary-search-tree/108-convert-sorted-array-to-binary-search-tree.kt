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
    private fun createNode(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }

        val middle = (start + end) / 2
        val node = TreeNode(nums[middle])
        node.left = createNode(nums, start, middle - 1)
        node.right = createNode(nums, middle + 1, end)

        return node
    }

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return createNode(nums, 0, nums.size - 1)
    }
}