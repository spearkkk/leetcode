class Solution {
    //dp, top-down
//    fun wordBreak(s: String, wordDict: List<String>): Boolean { 
//        val n = s.length
//        val words = wordDict.toSet()
//        val memo = mutableMapOf<Int, Boolean>()
//
//        fun dfs(leftCursor: Int): Boolean {
//            if (leftCursor == n) {
//                return true
//            }
//
//            if (memo[leftCursor] != null) {
//                return memo[leftCursor]!!
//            }
//
//            for (rightCursor in leftCursor .. n) {
//                val left = s.slice(leftCursor until rightCursor)
//                if (words.contains(left) && dfs(rightCursor)) {
//                    memo[leftCursor] = true
//                    return true
//                }
//            }
//            memo[leftCursor] = false
//            return false
//        }
//
//        return dfs(0)
//    }

    // dp, bottom-up
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val n = s.length
        val words = wordDict.toSet()
        val dp = BooleanArray(n + 1) { false }
        dp[0] = true

        for (leftCursor in 0 until n) {
            for (rightCursor in leftCursor + 1 .. n) {
                val sub = s.slice(leftCursor until rightCursor)

                if (words.contains(sub) && dp[leftCursor]) {
                    dp[rightCursor] = true
                }
            }
        }
        return dp[n]
    }
}