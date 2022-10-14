class Solution {
    private fun probe(node: TreeNode, queue: MutableList<Int>, k: Int) {
        if (queue.size >= k) {
            return
        }
        
        if (node.left != null) {
            probe(node.left!!, queue, k)
        }
        queue.add(node.`val`)
        if (node.right != null) {
            probe(node.right!!, queue, k)
        }
    }
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val queue = mutableListOf<Int>()
        probe(root!!, queue, k)

        return queue[k - 1]
    }
}