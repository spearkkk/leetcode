class Solution {
    fun minStartValue(nums: IntArray): Int {
        var min = 1
        var sum = 0
        for (num in nums) {
            sum += num

            if (sum <= 0) {
                min = kotlin.math.min(min, sum)
            }
        }

        return if (min <= 0) -1 * min + 1 else 1
    }
}