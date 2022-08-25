class Solution {
    private val holder: MutableMap<Int, Int> = mutableMapOf()

    private fun dig(arr: IntArray, k: Int, cur: Int): Int {
        if (cur >= arr.size) {
            holder[cur] = 0
            return 0
        }

        if (holder[cur] != null) {
            return holder[cur]!!
        }

        /// cur위치에서 k를 선택할 때, 충분히 선택할 값이 남아 있지 않다면
        /// 남은 값 중의 최대 값으로 채운 서브 배열이 된다.
        if (cur + k >= arr.size) {
            var cnt = 0
            var max = -1
            for (i in cur until arr.size) {
                cnt += 1
                if (max < arr[i]) {
                    max = arr[i]
                }
            }

            holder[cur] = cnt * max
            return cnt * max
        }

        /// 현재 값만 선택하고 나머지 배열에서 부분 배열을 만들 경우
        var candi = arr[cur] + dig(arr, k, cur + 1)

        /// 현재 값을 선택하면서 값을 구한다.
        /// 값이 위에서 구한 값보다 크면 업데이트 한다.
        for (i in 1 .. k) {
            var max = -1
            for (j in cur until cur + i) {
                if (max < arr[j]) {
                    max = arr[j]
                }
            }
            val tmp = max * i + dig(arr, k, cur + i)
            if (candi < tmp) {
                candi = tmp
            }
        }

        holder[cur] = candi
        return candi
    }

    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        return dig(arr, k, 0)
    }
}