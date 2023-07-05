class Solution {
    fun maximizeSum(nums: IntArray, k: Int): Int {
        val num: Int = nums.max()!!
        return num.times(k) + ((k - 1) * k / 2)
    }
}