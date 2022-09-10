class Solution {
    private fun seek(node: ListNode, footprint: MutableMap<Int, Int>): ListNode? {
        if (node.next == null) {
            footprint[node.`val`] = (footprint[node.`val`] ?: 0) + 1
            return if ((footprint[node.`val`] ?: 0) >= 2) null else node
        }

        footprint[node.`val`] = (footprint[node.`val`] ?: 0) + 1
        val next = seek(node.next!!, footprint)

        if ((footprint[node.`val`] ?: 0) >= 2) {
            return next
        }
        node.next = next
        return node

    }


    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        return seek(head, mutableMapOf())
    }
}