class Solution {
    fun thirdMax(nums: IntArray): Int {
        val holder = hashSetOf<Int>()
        var first: Long = Int.MIN_VALUE.toLong() - 1
        var second: Long = Int.MIN_VALUE.toLong() - 1
        var third: Long = Int.MIN_VALUE.toLong() - 1

        for (cur in nums) {
            if (holder.contains(cur)) {
                continue
            }
            holder.add(cur)

            if (cur >= first) {
                third = second
                second = first
                first = cur.toLong()
            } else if (cur >= second) {
                third = second
                second = cur.toLong()
            } else if (cur > third) {
                third = cur.toLong()
            }
        }
        return if (third == Int.MIN_VALUE.toLong() - 1) first.toInt() else third.toInt()
    }
}