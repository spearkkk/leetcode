class Solution {
    private fun reverse(start: ListNode, end: ListNode): Pair<ListNode, ListNode> {
        val holder = mutableListOf<ListNode>()

        var currentNode = start
        while (currentNode != end) {
            holder.add(currentNode)
            currentNode = currentNode.next!!
        }
        holder.add(end)

        for (i in (0 until holder.size).reversed()) {
            if (i == 0) {
                holder[i].next = null
            } else {
                holder[i].next = holder[i - 1]
            }
        }
        return Pair(holder.last(), start)
    }

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left >= right) {
            return head
        }

        var ahead: ListNode? = null
        var tailing: ListNode?

        var count = 1
        var cursor: ListNode = head!!
        while (count < left) {
            ahead = cursor
            cursor = cursor!!.next!!
            count += 1
        }

        count = 0
        while (count < (right - left)) {
            cursor = cursor.next!!
            count += 1
        }
        tailing = cursor.next

        val startAndEnd: Pair<ListNode, ListNode> = reverse(if (ahead == null) head else ahead.next!!, cursor)
        val result = if (ahead != null) {
            ahead.next = startAndEnd.first
            startAndEnd.second.next = tailing
            head
        } else {
            startAndEnd.second.next = tailing
            startAndEnd.first
        }

        return result
    }
}