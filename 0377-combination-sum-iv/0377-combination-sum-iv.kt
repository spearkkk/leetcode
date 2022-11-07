class Solution {
    private val memoization = mutableMapOf<Int, Int>()

    private fun dig(nums: IntArray, target: Int, cursor: Int, currentSum: Int): Int {
        if (target == currentSum) {
            return 1
        }

        if (memoization.containsKey(target - currentSum)) {
            return memoization[target - currentSum]!!
        }

        if (cursor > nums.size - 1 || target < currentSum) {
            return 0
        }
        
        val cnt = dig(nums, target, 0, currentSum + nums[cursor]) + dig(nums, target, cursor + 1, currentSum)

        memoization[target - currentSum] = cnt
        return cnt
    }

    fun combinationSum4(nums: IntArray, target: Int): Int {
        return dig(nums, target, 0, 0)
    }
}