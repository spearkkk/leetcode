class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val holder = hashSetOf<Int>()

        for (i in nums) {
            if (holder.contains(i)) {
                return true
            }
            holder.add(i)
        }
        return false
    }
}