class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        if (nums.size < 2) return nums.size
        val up = IntArray(nums.size) { 0 }
        val down = IntArray(nums.size) { 0 }

        var cursor = 1
        while (cursor < nums.size) {
            val current = nums[cursor - 1] - nums[cursor]

            if (current == 0) {
                up[cursor] = up[cursor - 1]
                down[cursor] = down[cursor - 1]
                cursor += 1
                continue
            }

            if (current < 0) {
                up[cursor] = down[cursor - 1] + 1
                down[cursor] = down[cursor - 1]
            } else {
                up[cursor] = up[cursor - 1]
                down[cursor] = up[cursor -  1] + 1
            }
            cursor += 1
        }

        return kotlin.math.max(up[nums.size - 1], down[nums.size - 1]) + 1
    }
}