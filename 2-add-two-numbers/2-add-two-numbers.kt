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
    private fun add(left: ListNode?, right: ListNode?, result: ListNode, carry: Int) {
        if (left == null && right == null) {
            if (carry > 0) result.next = ListNode(carry)
            return
        }
        
        val sum = (left?.`val` ?: 0) + (right?.`val` ?: 0) + carry
        val currentVal = sum % 10
        val carry = sum / 10

        val node = ListNode(currentVal)
        result.next = node

        return add(left?.next, right?.next, node, carry)
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val result = ListNode(0)
        add(l1, l2, result, 0)
        return result.next
    }
}
