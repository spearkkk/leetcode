class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return head

        val anotherHead = head.next ?: return head

        var firstCursor: ListNode? = head
        var secondCursor: ListNode? = anotherHead

        while (secondCursor?.next != null) {
            firstCursor?.next = secondCursor.next
            secondCursor.next = firstCursor?.next!!.next
            firstCursor = firstCursor.next
            secondCursor = secondCursor.next
        }
        firstCursor?.next = anotherHead

        return head
    }
}