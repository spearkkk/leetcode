class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { Int.MIN_VALUE }
        var cnt = 0

        fun binarySearch(target: Int): Int {
            var start = 0
            var end = cnt
            var index = 0

            while (start <= end) {
                val mid = (end + start) / 2

                if (target <= dp[mid]) {
                    index = mid
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            }

            if (start > cnt) {
                return -1
            }
            return index
        }

        for (cursor in nums.indices) {
            val index = binarySearch(nums[cursor])
            if (index == -1) {
                dp[cnt] = nums[cursor]
                cnt += 1
                continue
            }
            dp[index] = nums[cursor]
        }

        return cnt
    }
}
