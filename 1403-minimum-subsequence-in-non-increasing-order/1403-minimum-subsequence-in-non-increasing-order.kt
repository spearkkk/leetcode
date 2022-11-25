class Solution {
    fun minSubsequence(nums: IntArray): List<Int> {
        nums.sortDescending()
        
        var max = nums.sum()
        var sum = 0
        val result = mutableListOf<Int>()
        
        for (num in nums) {
            max -= num
            sum += num
            
            result.add(num)
            
            if (max < sum) {
                break
            }
        }
        
        return result
    }
}