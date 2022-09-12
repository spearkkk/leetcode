class Solution {
    private var first: TreeNode? = null
    private var second: TreeNode? = null
    private var prev = TreeNode(Int.MIN_VALUE)

    private fun traverse(parent: TreeNode?) {
        if (parent == null) {
            return
        }

        traverse(parent.left)


        if (first == null && prev.`val` > parent.`val`) {
            first = prev
        }

        if (first != null && prev.`val` > parent.`val`) {
            second = parent
        }
        prev = parent

        traverse(parent.right)
    }

    fun recoverTree(root: TreeNode?): Unit {
        if (root == null) {
            return
        }
        traverse(root)

        val tmp = first!!.`val`
        first!!.`val` = second!!.`val`
        second!!.`val` = tmp
    }
}