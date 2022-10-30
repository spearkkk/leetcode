class Solution {
    private val memoization = mutableMapOf<Int, Set<Int>>()

    private fun check(left: Int, right: Int): Boolean {
        return left % right == 0 || right % left == 0
    }

    private fun probe(nums: IntArray, cursor: Int): MutableSet<Int> {
        if (memoization.containsKey(cursor)) {
            return memoization[cursor]!!.toMutableSet()
        }

        var max: MutableSet<Int> = mutableSetOf()
        val divider = if (cursor == 0) 1 else nums[cursor - 1]
        for (anotherCursor in cursor until nums.size) {
            if (check(divider, nums[anotherCursor])) {
                val anotherResult = probe(nums, anotherCursor + 1).toMutableSet()
                anotherResult.add(nums[anotherCursor])

                if (anotherResult.size > max.size) {
                    max = anotherResult
                }
            }
        }
        memoization[cursor] = max
        return max
    }

    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        nums.sort()
        return probe(nums, 0).sorted()
    }
}