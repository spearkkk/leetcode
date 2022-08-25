
class Solution {
    private fun permute2(nums: IntArray): List<List<Int>> {
        if (nums.size == 2) {
            return listOf(listOf(nums[0], nums[1]), listOf(nums[1], nums[0]))
        }

        val nextResult = mutableListOf<List<Int>>()
        for (cursor in nums.indices) {
            val currentValue = nums[cursor]
            val currentResult = permute2(nums.withIndex().filter { it.index != cursor }.map { it.value }.toIntArray())

            for (i in currentResult) {
                val last = i.toMutableList()
                last.add(0, currentValue)
                nextResult.add(last)
            }
        }


        return nextResult
    }
    fun permute(nums: IntArray): List<List<Int>> {
        if (nums.size < 2) {
            return listOf(nums.toList())
        }
        return permute2(nums)
    }
}
