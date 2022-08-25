class Solution {
    private fun shift(zeroPosition: Int, lastPosition: Int, nums: IntArray): Unit {
        for (i in zeroPosition until lastPosition) {
            nums[i] = nums[i + 1]
        }
        nums[lastPosition] = 0
    }
    fun moveZeroes(nums: IntArray) {
        for (i in 1..nums.size) {
            val currentPosition = nums.size - i

            val zeroPosition = nums.slice(0 until currentPosition).lastIndexOf(0)
            if (zeroPosition == -1) {
                break
            }
            shift(zeroPosition, currentPosition, nums)

        }
    }
}
