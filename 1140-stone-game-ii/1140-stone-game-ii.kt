class Solution {
  // https://youtu.be/hYi2yBhO8d4
    fun stoneGameII(piles: IntArray): Int {
        val acc = IntArray(piles.size)
        acc[acc.size - 1] = piles.last()

        for (i in piles.size - 2 downTo 0) {
            acc[i] = acc[i + 1] + piles[i]
        }

        val memo = Array(101) { IntArray(101) { -1 } }

        fun helper(i: Int, m: Int): Int {
            if (i + 2 * m >= acc.size) {
                return acc[i]
            }

            if (memo[i][m] != -1) {
                return memo[i][m]
            }

            var min = Int.MAX_VALUE
            for (x in 1 .. 2 * m) {
                min = kotlin.math.min(min, helper(i + x, kotlin.math.max(x, m)))
            }

            memo[i][m] = acc[i] - min
            return memo[i][m]
        }

        return helper(0, 1) // index, M
    }
}