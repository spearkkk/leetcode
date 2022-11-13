class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = Array(text1.length + 1) { IntArray(text2.length + 1) { 0 } }

        for (y in 1 until dp.size) {
            val left = text1[y - 1]

            for (x in 1 until dp[y].size) {
                val right = text2[x - 1]

                if (left != right) {
                    dp[y][x] = kotlin.math.max(dp[y][x - 1], dp[y - 1][x])
                } else {
                    dp[y][x] = dp[y - 1][x - 1] + 1
                }
            }
        }

        return dp[dp.size - 1][dp[0].size - 1]
    }
}