class Solution {
    fun minOperations(nums: IntArray): Int {
        var result = 0

        for (idx in 1 until nums.size) {
            if (nums[idx - 1] >= nums[idx]) {
                result += nums[idx - 1] + 1 - nums[idx]
                nums[idx] = nums[idx - 1] + 1
            }
        }

        return result
    }
}