class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val holder = BooleanArray(nums.size + 2) { false }
        holder[0] = true
        
        for (num in nums) {
            if (num <= 0 || num > nums.size) {
                continue
            }
            holder[num] = true
        }
        
        return holder.indexOfFirst { !it }
    }
}
