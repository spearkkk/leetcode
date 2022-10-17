class Solution {
    private fun probe(nums: IntArray, result: IntArray, cursor: Int, before: Int): Int {
        if (cursor == nums.size - 1) {
            result[cursor] = before
            return nums[cursor]
        }

        val after = probe(nums, result, cursor + 1, before * nums[cursor])
        result[cursor] = before * after
        return after * nums[cursor]
    }

    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 0 }

        probe(nums, result, 0, 1)
        return result
    }
}