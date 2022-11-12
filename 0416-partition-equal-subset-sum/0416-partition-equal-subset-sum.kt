class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()

        if (sum % 2 == 1) return false

        val target = sum / 2

        val dp = BooleanArray(target + 1) { false }
        dp[0] = true

        for (num in nums) {
            var tmp = target
            while (tmp >= num) {
                dp[tmp] = dp[tmp] || dp[tmp - num]
                tmp -= 1
            }
        }

        return dp[target]
    }
}