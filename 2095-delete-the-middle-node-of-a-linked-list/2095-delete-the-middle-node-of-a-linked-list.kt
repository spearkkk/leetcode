class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head == null) return null

        var left: ListNode = head
        var right: ListNode = head
        var count = 1

        while (right.next != null) {
            right = right.next!!
            count += 1
        }
        
        if (count < 2) {
            return null
        }

        for (i in 1 until count / 2) {
            left = left.next!!
        }

        left.next = left.next!!.next
        return head
    }
}