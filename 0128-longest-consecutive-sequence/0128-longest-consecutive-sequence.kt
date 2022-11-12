class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toMutableSet()

        var len = 0

        for (num in nums) {
            val prev = num - 1
            if (set.contains(prev)) {
                continue
            }

            var current = num
            var currentLen = 1
            while (set.contains(current + 1)) {
                current += 1
                currentLen += 1
            }

            len = kotlin.math.max(len, currentLen)
        }

        return len
    }
}