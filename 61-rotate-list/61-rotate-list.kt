class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        /// 엣지 케이스
        if (head?.next == null) {
            return head
        }

        /// head 노드를 이미 포함한 상황
        var cnt = 1
        
        /// 맨 마지막 노드를 기억했다가 나중에 연결해줄 예정
        val last: ListNode?

        /// 개수와 맨 마지막 노드 구하기
        var current: ListNode = head
        while (current.next != null) {
            current = current.next!!
            cnt += 1
        }
        last = current

        /// k 수 최적화, 최적화 이후 0이라면 할 일이 없기 때문에 바로 반환
        val n = k % cnt
        if (n == 0) {
            return head
        }
        
        /// n(k)만큼 위치를 이동 다만, 이미 head가 1을 포함하고 있는 점을 감안
        var newLast: ListNode = head
        for (ignored in 1 until (cnt - n)) {
            newLast = newLast.next!!
        }

        /// 연결해주기
        val newHead = newLast.next
        newLast.next = null
        last.next = head

        return newHead
    }
}