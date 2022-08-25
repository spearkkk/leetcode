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
    fun deleteNode(node: ListNode?) {
        var cur = node
        while (true) {
            cur!!.`val` = cur!!.next!!.`val`

            if (cur!!.next!!.next == null) {
                cur.next = null
                break
            }

            cur = cur.next
        }
    }
}
