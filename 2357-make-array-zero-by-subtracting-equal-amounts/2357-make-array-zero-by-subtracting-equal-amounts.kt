class Solution {
    fun minimumOperations(nums: IntArray): Int {
        var holder = nums.toSortedSet()

        var result = 0
        while (holder.isNotEmpty()) {
            val min: Int = holder.first()

            val next = arrayListOf<Int>()

            for (num in holder) {
                if (num - min > 0) {
                    next.add(num - min)
                }
            }

            holder = next.toSortedSet()

            if (min > 0) {
                result += 1
            }
        }

        return result
    }
}