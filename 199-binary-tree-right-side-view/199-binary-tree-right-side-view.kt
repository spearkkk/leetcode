class Solution {
    private fun probe(stack: MutableList<TreeNode>, result: MutableList<Int>) {
        if (stack.isEmpty()) {
            return
        }
        
        result.add(stack.get(stack.size - 1).`val`)
        
        val nextStack = mutableListOf<TreeNode>()
        while (stack.isNotEmpty()) {
            val node = stack.removeAt(0)
            if (node.left != null) nextStack.add(node.left!!)
            if (node.right != null) nextStack.add(node.right!!)
        }
        probe(nextStack, result)
    }
    
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val result = mutableListOf<Int>()
        probe(mutableListOf(root), result)

        return result
    }
}