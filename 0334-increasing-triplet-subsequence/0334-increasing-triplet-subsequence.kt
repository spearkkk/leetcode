class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        val dp = IntArray(nums.size) { Int.MIN_VALUE }
        var cnt = 0

        fun bSearch(target: Int): Int {
            var start = 0
            var end = cnt
            var index = 0

            while (start <= end) {
                val mid = (start + end) / 2

                if (target <= dp[mid]) {
                    index = mid
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            }

            if (start >= cnt) {
                return -1
            }
            return index
        }

        for (cursor in nums.indices) {
            val index = bSearch(nums[cursor])
            if (index == -1) {
                dp[cnt] = nums[cursor]
                cnt += 1
            } else {
                dp[index] = nums[cursor]
            }
            
            if (cnt >= 3) {
                return true
            }
        }

        return false
    }
}