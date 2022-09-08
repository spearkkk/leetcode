class Solution {
    private fun seek(node: TreeNode?): String {
        if (node == null) {
            return ""
        }
        if (node.left == null && node.right == null) {
            return "${node.`val`}"
        }
        if (node.right == null) {
            return "${node.`val`}(${seek(node.left)})"
        }
        return "${node.`val`}(${seek(node.left)})(${seek(node.right)})"
    }
    fun tree2str(root: TreeNode?): String {
        return seek(root)
    }

}