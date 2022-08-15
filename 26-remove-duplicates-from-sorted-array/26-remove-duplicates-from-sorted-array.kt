class Solution {
    fun removeDuplicates(nums: IntArray): Int {

        var count = 0
        var currentValue = -10001
        var currentPosition = 0

        while (currentPosition < nums.size) {
            if (currentValue < nums[currentPosition]) {
                nums[count] = nums[currentPosition]
                count += 1
                currentValue = nums[currentPosition]
                currentPosition += 1


            } else {
                currentPosition += 1
            }
        }
        return count
    }
}