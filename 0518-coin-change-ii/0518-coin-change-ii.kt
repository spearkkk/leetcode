class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(5000 + 1) { 0 }
        dp[0] = 1

        for (coin in coins) {
            for (cursor in coin .. amount) {
                dp[cursor] += dp[cursor - coin]
            }
        }
        return dp[amount]
    }
}