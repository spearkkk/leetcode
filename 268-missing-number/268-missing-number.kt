class Solution {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        return (n * (n + 1) - (nums.sum() * 2)) / 2
    }
}