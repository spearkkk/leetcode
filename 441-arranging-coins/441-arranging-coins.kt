class Solution {
    private fun minimum(cur: Long): Long {
        return cur * (cur + 1)
    }
    private fun maximum(cur: Long): Long {
        return (cur + 1) * (cur + 2)
    }

    fun arrangeCoins(n: Int): Int {

        var cur = 1
        while (true) {
            /// cur 까지의 합과 cur + 1까지의 합을 구한다.
            /// n이 위에서의 구한 합 사이에 있다면 그 순간이 비어있는 순간이다.
            val tmp = n * 2L
            if (minimum(cur.toLong()) <= tmp
                    && tmp < maximum(cur.toLong())) {
                return cur
            }
            cur += 1
        }
    }
}