class Solution {
    fun singleNumber(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            if (set.contains(num)) {
                set.remove(num)
            } else {
                set.add(num)
            }
        }

        return set.first()
    }
}