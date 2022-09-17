class Solution {
    private fun seek(node: TreeNode, currentPath: MutableList<Int>, result: MutableList<List<Int>>, targetSum: Int, sum: Int) {
        if (targetSum == sum + node.`val` && node.left == null && node.right == null) {
            result.add(currentPath.toMutableList() + node.`val`)
            return
        }

        if (node.left != null) {
            seek(node.left!!, (currentPath.toMutableList() + node.`val`).toMutableList(), result, targetSum, sum + node.`val`)
        }
        if (node.right != null) {
            seek(node.right!!, (currentPath.toMutableList() + node.`val`).toMutableList(), result, targetSum, sum + node.`val`)
        }
    }

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        val result = mutableListOf<List<Int>>()

        seek(root, mutableListOf(), result, targetSum, 0)

        return result
    }
}