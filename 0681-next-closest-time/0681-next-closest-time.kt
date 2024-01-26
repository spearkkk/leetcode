class Solution {
    fun nextClosestTime(time: String): String {
        fun aToi(a: Char): Int {
            return a.code - '0'.code
        }

        val nums = IntArray(4)

        nums[0] = aToi(time[0])
        nums[1] = aToi(time[1])
        nums[2] = aToi(time[3])
        nums[3] = aToi(time[4])

        val numberTime = nums[0] * 1000 + nums[1] * 100 + nums[2] * 10 + nums[3]

        val candi = sortedSetOf<Int>()

        fun bt(cnt: Int, num: Int) {
            if (cnt == 4) {
                val hr = num / 100
                val min = num % 100
                if (hr in 0 until 24 && min in 0 until 60) {
                    candi.add(num)
                }
                return
            }

            for (i in 0 until 4) {
                bt(cnt + 1, num * 10 + nums[i])
            }
        }

        bt(0, 0)

        val sorted = candi.toList()
        val k = (sorted.withIndex().find { it.value == numberTime }!!.index + 1) % sorted.size

        return "%02d:%02d".format(sorted[k] / 100, sorted[k] % 100)
    }
}