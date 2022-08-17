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
    private fun isSame(left: ListNode?, right: ListNode?): Boolean {
        if (left == null || right == null) {
            return true
        }
        return left.`val` == right.`val` && isSame(left.next, right.next)
    }

    private fun reverse(current: ListNode, prev: ListNode?) {
        val tmp = current.next
        current.next = prev
        if (tmp != null) {
            reverse(tmp, current)
        }
    }

    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) {
            return true
        }
        var fast = head
        var slow = head

        do {
            fast = if (fast!!.next!!.next == null) fast!!.next else fast!!.next!!.next
            slow = slow!!.next
        } while (fast!!.next != null)

        reverse(slow!!, null)

        return isSame(head, fast)

    }
}
