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
    fun hasCycle(head: ListNode?): Boolean {
        val footprint = HashSet<ListNode>()

        var currentNode = head
        while (currentNode != null) {
            if (footprint.contains(currentNode)) {
                return true
            }
            footprint.add(currentNode)
            currentNode = currentNode.next
        }
        return false
    }
}
