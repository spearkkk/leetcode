class Solution {
    private fun seek(nums: IntArray, result: MutableList<List<Int>>, count: Int, start: Int, current: MutableList<Int>) {
        if (count == current.size) {
            result.add(current.toList())
            return
        }

        for (cursor in start until nums.size) {
            val next = current.toMutableList()
            next.add(nums[cursor])
            seek(nums, result, count, cursor + 1, next)
        }
    }

    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for (count in 0 .. nums.size) {
            seek(nums, result, count, 0, mutableListOf())
        }

        return result
    }
}