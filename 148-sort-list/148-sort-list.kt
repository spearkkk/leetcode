class Solution {
    fun sortList(head: ListNode?): ListNode? {
        val newHead = ListNode(-5001)
        newHead.next = head

        var cur: ListNode = newHead

        while (cur.next != null) {
            if (cur.`val` <= cur.next!!.`val`) {
                cur = cur.next!!
                continue
            }

            var anotherCur: ListNode = newHead
            while (anotherCur.next!! != cur && anotherCur.next!!.`val` < cur.next!!.`val`) {
                anotherCur = anotherCur.next!!
            }
            val movingNode = cur.next!!
            cur.next = cur.next!!.next

            movingNode.next = anotherCur.next!!
            anotherCur.next = movingNode
        }
        return newHead.next
    }
}