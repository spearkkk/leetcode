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
    private fun swap(node: ListNode?): ListNode? {
        if (node?.next == null) {
            return node
        }

        val nextNode: ListNode = node.next!!

        val tmp = nextNode.next

        nextNode.next = node
        node.next = swap(tmp)

        return nextNode
    }

    fun swapPairs(head: ListNode?): ListNode? {
        return swap(head)
    }
}