class Solution {
    private val memoization = mutableSetOf<List<Int>>()
    private fun seek(nums: IntArray, start: Int, count: Int, current: List<Int>, result: MutableList<List<Int>>) {
        if (count == current.size) {
            if (memoization.contains(current.sorted())) {
                return
            }
            memoization.add(current.sorted())
            result.add(current)
            return
        }

        if (start >= nums.size) {
            return
        }

        val next = current.toMutableList()
        next.add(nums[start])
        seek(nums, start + 1, count, next, result)
        seek(nums, start + 1, count, current, result)
    }

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for (count in 0 .. nums.size) {
            seek(nums, 0, count, mutableListOf(),  result)
        }

        return result
    }
}