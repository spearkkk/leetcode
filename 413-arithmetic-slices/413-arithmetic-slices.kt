class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size <= 2) {
            return 0
        }

        val holder = IntArray(nums.size) { Int.MAX_VALUE }

        for (i in 0 until nums.size - 1) {
            holder[i] = nums[i + 1] - nums[i]
        }

        var sum = 0
        var i = 0
        var count = 0

        while (i < holder.size - 1) {
            if (holder[i] == holder[i + 1]) {
                count += 1
                i += 1
                continue
            }

            if (count >= 1) {
                sum += (1 .. count).sum()
            }
            count = 0
            i += 1
        }

        return sum
    }
}