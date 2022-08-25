class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var count = 0
        var maxCount = 0

        for (cur in nums) {
            if (cur == 0) {
                if (count > maxCount) {
                    maxCount = count
                }
                count = 0
                continue
            }
            count += 1
        }
        return if(maxCount > count) maxCount else count
    }
}