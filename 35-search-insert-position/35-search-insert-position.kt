class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        for (index in nums.indices) {
            if (nums[index] == target) {
                return index
            }
            if (nums[index] > target) {
                return index
            }
        }
        return nums.size
    }
}
