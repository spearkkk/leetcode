class Solution {
    private fun del(node: TreeNode?, targets: Set<Int>, answer: MutableList<TreeNode?>): TreeNode? {
        if (node == null) {
            return null
        }

        node.left = del(node.left, targets, answer)
        node.right = del(node.right, targets, answer)
        if (targets.contains(node.`val`)) {
            if (node.left != null) {
                answer.add(node.left)
            }

            if (node.right != null) {
                answer.add(node.right)
            }

            return null
        }
        return node
    }

    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        val targets = to_delete.toSet()

        val answer = mutableListOf<TreeNode?>()
        if (!targets.contains(root!!.`val`)) {
            answer.add(root)
        }
        del(root, targets, answer)

        return answer
    }
}