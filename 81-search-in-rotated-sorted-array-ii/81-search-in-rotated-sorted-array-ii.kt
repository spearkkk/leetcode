class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        return nums.find { it == target } != null
    }
}