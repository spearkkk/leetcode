class Solution {
    fun findMin(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return -5000
        }
        
        var cur = nums[0]
        
        for (idx in 1 until nums.size) {
            if (nums[idx] < cur) {
                return nums[idx]
            }
            
            cur = nums[idx]
        }

        return nums[0]
    }
}