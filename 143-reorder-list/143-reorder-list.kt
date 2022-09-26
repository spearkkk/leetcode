class Solution {
    fun reorderList(head: ListNode?): Unit {
        val footprint = mutableListOf<ListNode>()

        var cursor: ListNode? = head
        while (cursor != null) {
            footprint.add(cursor)
            cursor = cursor.next
        }


        cursor = null
        while (footprint.isNotEmpty()) {
            val node = footprint.removeAt(0)
            node.next = null
            
            if (cursor != null) {
                cursor.next = node
            }
            
            if (footprint.isEmpty()) {
                break
            }
            
            val next = footprint.removeAt(footprint.size - 1)
            next.next = null

            node.next = next

            cursor = next
        }
    }
}