class Solution {
    fun countHillValley(nums: IntArray): Int {
        if (nums.size < 3) return 0

        var flag = nums[0] - nums[1] // > 0: down, < 0: up, == 0: horizontal
        var count = 0

        var cursor = 2
        while (cursor < nums.size) {
            val current = nums[cursor - 1] - nums[cursor]

            if (current == 0) {
                cursor += 1
                continue
            }

            if (flag * current < 0) {
                count += 1
            }
            flag = current
            cursor += 1
        }
        return count
    }
}