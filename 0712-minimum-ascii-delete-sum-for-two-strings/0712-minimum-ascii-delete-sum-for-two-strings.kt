class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        fun lcs(s1: String, s2: String): Int {
            val dp = Array(s1.length + 1) { IntArray(s2.length + 1) { 0 } }

            for (y in 1 until dp.size) {
                val left = s1[y - 1]

                for (x in 1 until dp[y].size) {
                    val right = s2[x - 1]

                    if (left != right) {
                        dp[y][x] = kotlin.math.max(dp[y - 1][x], dp[y][x - 1])
                    } else {
                        dp[y][x] = dp[y - 1][x - 1] + left.toInt()
                    }
                }
            }

            var max = 0
            for (row in dp) {
                for (elem in row) {
                    max = kotlin.math.max(max, elem)
                }
            }
            return max
        }


        val max = kotlin.math.max(lcs(s1, s2), lcs(s2, s1))

        return (s1 + s2).map { it.toInt() }.sum() - (max * 2)
    }
}