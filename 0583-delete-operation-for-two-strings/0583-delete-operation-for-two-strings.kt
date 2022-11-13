class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) { 0 } }

        for (y in 1 until dp.size) {
            val left = word1[y - 1]

            for (x in 1 until dp[y].size) {
                val right = word2[x - 1]

                if (left != right) {
                    dp[y][x] = kotlin.math.max(dp[y - 1][x], dp[y][x - 1])
                } else {
                    dp[y][x] = dp[y - 1][x - 1] + 1
                }
            }
        }

        val max = dp[dp.size - 1][dp[0].size - 1]
        return (word1.length - max) + (word2.length - max)
    }
}