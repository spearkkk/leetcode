class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null || n < 1) {
            return head
        }

        fun remove(node: ListNode?, prevNode: ListNode, n: Int): Int {
            if (node == null) {
                return 1
            }

            val current = remove(node.next, node, n)
            if (current == n) {
                prevNode.next = node.next
            }
            return current + 1
        }


        val current = remove(head.next, head, n)
        if (current == n) {
            return head.next
        }

        return head
    }
}