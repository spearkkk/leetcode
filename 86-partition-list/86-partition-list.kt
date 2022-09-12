class Solution {
    private fun seek(node: ListNode, x: Int): Pair<ListNode?, ListNode?> {
        if (node.next == null) {
            return if (node.`val` >= x) Pair(null, node) else Pair(node, null)
        }

        val leftAndRight = seek(node.next!!, x)

        return if (node.`val` >= x) {
            node.next = leftAndRight.second
            Pair(leftAndRight.first, node)
        } else {
            node.next = leftAndRight.first
            Pair(node, leftAndRight.second)
        }
    }

    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head == null) {
            return null
        }

        val leftAndRight = seek(head, x)

        /// left 값이 있을 때 연결해준다.
        if (leftAndRight.first != null) {
            /// 연결할 때에는 맨 마지막까지 찾은 후, 연결한다.
            var leftEnd: ListNode = leftAndRight.first!!
            while (leftEnd.next != null) {
                leftEnd = leftEnd.next!!
            }
            leftEnd.next = leftAndRight.second
            return leftAndRight.first
        }
        return leftAndRight.second
    }
}