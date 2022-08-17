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
    // 현재 노드의 `next` 값이 `val`와 같으면 현재 노드의 `next` 값을 그 다음의 `next`로 교체하는 작업
    // 1 -> 2 -> 3, 2일 때, 1 -> 3으로 연결 해준다.
    private fun remove(node: ListNode?, n: Int): ListNode? {
        if (node?.next == null) {
            return null
        }

        // 현재 노드의 `next`를 그 다음 `next`로 연결해주는 작업
        if (node!!.next!!.`val` == n) {
            node.next = node!!.next!!.next

            // `next`가 업데이트 되었으니 다시 한번 현재 노드 기준으로 평가해야 함.
            remove(node, n)
        }
        // 이상이 없으니 다음 노드를 대상으로 진행
        return remove(node.next, n)
    }

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        remove(head, `val`)

        // 처음 노드의 값이 `val`과 같을 때의 엣지 케이스를 고려한다.
        // 여기는 이미 하위의 노드들 중 `val`의 값을 가지는 노드는 사라진 후이다.
        if (head != null && head.`val` == `val`) {
            return head.next
        }
        return head
    }
}
