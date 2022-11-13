class Solution {
    fun findNumberOfLIS(nums: IntArray): Int {
        val n = nums.size
        var maxLength = 0

        val lengths = IntArray(n) { 1 }
        val counts = IntArray(n) { 1}

        for (rightIndex in nums.indices) {
            val right = nums[rightIndex]

            for (leftIndex in 0 until rightIndex) {
                val left = nums[leftIndex]

                if (left >= right) {
                    continue
                }

                if (lengths[leftIndex] + 1 == lengths[rightIndex]) {
                    counts[rightIndex] += counts[leftIndex]
                } else if (lengths[leftIndex] + 1 > lengths[rightIndex]) {
                    lengths[rightIndex] = lengths[leftIndex] + 1
                    counts[rightIndex] = counts[leftIndex]
                }

            }

            maxLength = kotlin.math.max(maxLength, lengths[rightIndex])
        }


        return lengths.withIndex().filter { it.value == maxLength }.map { counts[it.index] }.sum()
    }
}