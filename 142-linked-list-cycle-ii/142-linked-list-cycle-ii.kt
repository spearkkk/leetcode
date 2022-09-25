class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        val footprint = mutableSetOf<ListNode>()

        var cursor: ListNode = head
        while (cursor.next != null) {
            footprint.add(cursor)

            val nextCursor: ListNode = cursor.next!!

            if (footprint.contains(nextCursor)) {
                return nextCursor
            }

            cursor = nextCursor
        }

        return null
    }
}