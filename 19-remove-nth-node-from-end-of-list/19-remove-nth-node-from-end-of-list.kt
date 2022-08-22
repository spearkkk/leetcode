/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    private fun remove(node: ListNode, nextNode: ListNode?, n: Int): Int {
        if (nextNode != null) {
            val nth = remove(nextNode, nextNode.next, n)
            if (nth == n) {
                node.next = nextNode.next
            }
            return nth + 1
        }
        return 1
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }

        val nth = remove(head, head.next, n)
        if (nth == n) {
            return head.next
        }
        return head
    }
}
