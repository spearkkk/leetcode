class Solution {
    fun findDuplicate(nums: IntArray): Int {
        val holder = mutableSetOf<Int>()

        for (num in nums) {
            if (holder.contains(num)) {
                return num
            }
            holder.add(num)
        }
        return -1
    }
}