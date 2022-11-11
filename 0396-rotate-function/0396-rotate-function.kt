class Solution {
    fun maxRotateFunction(nums: IntArray): Int {
        val len = nums.size
        var sum = 0
        var candidate = 0

        for (cursor in nums.indices) {
            sum += nums[cursor]
            candidate += cursor * nums[cursor]
        }

        var max = candidate
        for (cursor in nums.indices.reversed()) {
            candidate = candidate + sum - nums[cursor] * len
            if (max < candidate) {
                max = candidate
            }
        }

        return max
    }
}