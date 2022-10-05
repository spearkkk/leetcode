class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return -1
        }
        
        var maxIndex = 0
        
        for (cursor in 1 until nums.size) {
            if (nums[maxIndex] < nums[cursor]) {
                maxIndex = cursor
            }
        }
        return maxIndex
    }
}