class Solution {
    fun makesquare(matchsticks: IntArray): Boolean {
        val sum = matchsticks.sum()

        if (sum % 4 != 0) {
            return false
        }

        val target = sum / 4

        val sums = IntArray(4) { 0 }
        
        matchsticks.sortDescending()
        fun dfs(cursor: Int): Boolean {
            if (cursor >= matchsticks.size) {
                if (sums[0] == target && sums[1] == target && sums[2] == target) {
                    return true
                }
                return false
            }

            for (anotherCursor in 0 .. 3) {
                if (sums[anotherCursor] + matchsticks[cursor] > target) {
                    continue
                }

                sums[anotherCursor] += matchsticks[cursor]
                if (dfs(cursor + 1)) {
                    return true
                }
                sums[anotherCursor] -= matchsticks[cursor]
            }
            return false
        }

        return dfs(0)
    }
}