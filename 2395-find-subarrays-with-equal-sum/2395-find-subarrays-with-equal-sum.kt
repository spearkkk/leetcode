class Solution {
    fun findSubarrays(nums: IntArray): Boolean {
        if (nums.size < 2) return false

        val set = mutableSetOf<Int>()

        var cursor = 1
        while (cursor < nums.size) {
            val sum = nums[cursor - 1] + nums[cursor]
            if (set.contains(sum)) {
                return true
            }
            set.add(sum)
            cursor += 1
        }

        return false
    }
}