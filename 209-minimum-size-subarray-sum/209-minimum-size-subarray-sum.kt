class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var right = 0
        var result = Int.MAX_VALUE
        var sum = 0

        while (right < nums.size) {
            sum += nums[right]
            right += 1
            while(sum >= target) {
                result = if (result < right - left) result else right - left
                sum -= nums[left]
                left += 1
            }
        }

        return if (result == Int.MAX_VALUE) 0 else result
    }
}