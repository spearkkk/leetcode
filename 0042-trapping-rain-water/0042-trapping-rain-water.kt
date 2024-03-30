class Solution {
    /**
     * 빗물이 고이기 위해서는 반드시 내려갔다가 다시 올라와야한다.
     * 내려가진 않고 오르기만 하면 빗물이 고이지 않는다.
     * 올라기진 않고 내려가기만 해도 빗물이 고이지 않는다.
     *
     * 내려간 이력이 있을 때, 올라가는 순간이 오면 빗물을 계산할 수 있다.
     *
     * Hint. stack, two pointer
     *
     * left: 현재 탐색했던 부분 중에서 제일 큰 벽의 위치
     * right: left보다 작은 벽을 탐색하다가 left 벽이랑 같거나 큰 벽을 만나는 순간을 캡쳐한다.
     *
     * stack: right 벽을 탐색하면서 만난 벽들의 높이
     */
    fun trap(height: IntArray): Int {
        val stack = mutableListOf<Int>()

        // 벽이 두개면 빗물을 모을 수 없다.
        if (height.size <= 2) {
            return 0
        }

        var left = 0
        var right = left + 1

        var total = 0

        fun calTotal(): Int {
            // height[right] 가 스택에 있는 높이보다 작은 경우가 있다
            // right가 끝에 도달에서 어쩔 수 없지 끝난 경우
            // 이럴 때 아래 공식이 통하지 않는다.
//            if (stack.isNotEmpty()) {
//                val h = kotlin.math.min(height[left], height[right])
//                val w = right - left - 1
//
//                return (h * w) - stack.sum()
//            }

            var h = kotlin.math.min(height[left], height[right])

            var tmp = 0
            while (stack.isNotEmpty()) {
                val candidate = stack.removeLast()
                if (h < candidate) {
                    h = candidate
                    continue
                }

                tmp += h - candidate
            }

            return tmp
        }

        while (right < height.size - 1) {
            while (height[right] < height[left]) {
                stack.add(height[right])
                right += 1

                // end point
                if (right == height.size - 1) {
                    break
                }
            }

            total += calTotal()

//            println("left: $left, right: $right, total: $total")

            stack.clear()
            left = right
            right += 1
        }

        return total
    }
}