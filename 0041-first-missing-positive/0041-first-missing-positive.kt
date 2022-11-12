class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val mark = BooleanArray(nums.size + 2) { false }
        mark[0] = true

        for (num in nums) {
            if (num <= 0 || num > nums.size) {
                continue
            }
            mark[num] = true
        }
        return mark.indexOfFirst { !it }
    }
}