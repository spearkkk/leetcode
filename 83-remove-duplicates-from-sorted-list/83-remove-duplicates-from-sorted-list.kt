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
    private fun deduplicate(node: ListNode?) {
        if (node == null) {
            return
        }

        val currentValue = node.`val`
        var nextOne = node.next
        /// current -> 1st -> 2nd 에서 1st와 2nd의 값이 값으면 1st를 버린다. 이 과정을 반복한다.
        while (nextOne != null && nextOne.`val` == currentValue) {
            nextOne = nextOne.next
        }
        
        node.next = nextOne
        deduplicate(nextOne)
    }
    fun deleteDuplicates(head: ListNode?): ListNode? {
        deduplicate(head)
        return head
    }
}
