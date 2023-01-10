class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val n = s.length
        val words = wordDict.toSet()
        val memo = mutableMapOf<Int, Boolean>()

        fun dfs(leftCursor: Int): Boolean {
            if (leftCursor == n) {
                return true
            }

            if (memo[leftCursor] != null) {
                return memo[leftCursor]!!
            }

            for (rightCursor in leftCursor .. n) {
                val left = s.slice(leftCursor until rightCursor)
                if (words.contains(left) && dfs(rightCursor)) {
                    memo[leftCursor] = true
                    return true
                }
            }
            memo[leftCursor] = false
            return false
        }

        return dfs(0)
    }
}