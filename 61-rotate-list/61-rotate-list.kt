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
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) {
            return head
        }

        var cnt = 1
        var last: ListNode?

        var current: ListNode = head
        while (current.next != null) {
            current = current.next!!
            cnt += 1
        }
        last = current

        val n = k % cnt
        if (n == 0) {
            return head
        }
        var newLast: ListNode = head
        for (ignored in 1 until (cnt - n)) {
            newLast = newLast.next!!
        }

        val newHead = newLast.next
        newLast.next = null
        last.next = head

        return newHead
    }
}