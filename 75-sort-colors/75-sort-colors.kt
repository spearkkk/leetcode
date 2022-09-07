class Solution {
    private fun swap(leftIndex: Int, rightIndex: Int, nums: IntArray) {
        if (leftIndex == rightIndex ){
            return
        }
        nums[leftIndex] = nums[leftIndex] + nums[rightIndex]
        nums[rightIndex] = nums[leftIndex] - nums[rightIndex]
        nums[leftIndex] = nums[leftIndex] - nums[rightIndex]
    }

    private fun sort(start: Int, end: Int, nums: IntArray, target: Int) {
        if (target >= 2) {
            return
        }

        var count = 0

        for (cursor in start .. end) {
            if (nums[cursor] == target) {
                swap(start + count, cursor, nums)
                count += 1
                continue
            }
        }

        sort(start + count, end, nums, target + 1)
    }

    fun sortColors(nums: IntArray): Unit {
        if (nums.size != 1) {
            sort(0, nums.size - 1, nums, 0)
        }
    }
}