class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == root || q == root) {
            return root
        }

        val left: TreeNode? = lowestCommonAncestor(root.left, p, q)
        val right: TreeNode? = lowestCommonAncestor(root.right, p, q)

        return if (left == null) {
           right
        } else {
            if (right == null) {
                left
            } else {
                root
            }
        }
    }
}