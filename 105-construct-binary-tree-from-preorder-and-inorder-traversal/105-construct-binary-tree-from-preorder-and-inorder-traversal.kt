class Solution {
    private fun build(preorder: IntArray, cursor: Int, inorder: IntArray, start: Int, end: Int): TreeNode? {
        if (cursor >= preorder.size || start > end) {
            return null
        }
        
        val node = TreeNode(preorder[cursor])
        
        for (inorderCursor in start .. end) {
            if (inorder[inorderCursor] == node.`val`) {
                node.left = build(preorder, cursor + 1, inorder, start, inorderCursor - 1)
                node.right = build(preorder, cursor + (inorderCursor - start) + 1, inorder, inorderCursor + 1, end)
            }
        }

        return node
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return build(preorder, 0, inorder, 0, inorder.size - 1)
    }
}