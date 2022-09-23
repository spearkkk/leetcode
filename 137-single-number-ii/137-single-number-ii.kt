class Solution {
    fun singleNumber(nums: IntArray): Int {
        val intToCount = mutableMapOf<Int, Int>()
        for (num in nums) {
            intToCount[num] = (intToCount[num]?: 0) + 1
            if (intToCount[num] == 3) {
                intToCount.remove(num)
            }
        }

        return intToCount.keys.first()
    }
}