class Solution {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        if (head == null || k < 1) return null

        fun swap(node: ListNode?, k: Int, holder: MutableList<ListNode>, count: Int): Int {
            if (node == null) {
                return 1
            }
            if (count == k) {
                holder.add(node)
            }

            val anotherNth = swap(node.next, k, holder, count + 1)

            if (anotherNth == k) {
                holder.add(node)
            }

            return anotherNth + 1
        }

        val holder = mutableListOf<ListNode>()
        swap(head, k, holder, 1)

        val tmp = holder[0].`val`
        holder[0].`val` = holder[1].`val`
        holder[1].`val` = tmp
        
        return head
    }
}