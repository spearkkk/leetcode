class Solution {
    fun longestPalindromeSubseq(s: String): Int {
        val dp = Array(s.length + 1) { IntArray(s.length + 1) { 0 } }

        for (y in (1 until dp.size).reversed()) {
            dp[y][y] = 1

            val left = s[y - 1]
            for (x in y + 1 until dp.size) {
                val right = s[x - 1]

                if (left == right) {
                    dp[y][x] = dp[y + 1][x - 1] + 2
                } else {
                    dp[y][x] = kotlin.math.max(dp[y][x - 1], dp[y + 1][x])
                }
            }

        }

        return dp[1][s.length]
    }
}