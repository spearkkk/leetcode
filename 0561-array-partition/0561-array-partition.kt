class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()

        return nums.withIndex().sumBy { if (it.index % 2 == 0) it.value else 0 }
    }
}