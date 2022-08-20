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
        /// 둘 다 null이면 끝이기 때문에 마지막 carry 값 여부에 따라 노드를 추가한다.
        if (left == null && right == null) {
            if (carry > 0) result.next = ListNode(carry)
            return
        }
        
        /// nullable일 수 있기 떄문에 기본 값을 0으로 해서 합을 구한다.
        val sum = (left?.`val` ?: 0) + (right?.`val` ?: 0) + carry
        val currentVal = sum % 10
        val carry = sum / 10

        /// 결과에다가 노드를 붙인다.
        val node = ListNode(currentVal)
        result.next = node

        /// 다음 노드 계산을 반복한다.
        return add(left?.next, right?.next, node, carry)
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val result = ListNode(0)
        add(l1, l2, result, 0)
        
        /// 루트노드를 임의값으로 했기 때문에 빼준다.
        return result.next
    }
}
