class Solution {
    private fun isPanlidrome(cur: String): Boolean {
        for (i in 0 until cur.length / 2) {
            if (cur[i] != cur[cur.length - i - 1]) {
                return false
            }
        }
        return true

    }

    fun countSubstrings(s: String): Int {
        var sum = s.length

        for (i in 2 .. s.length) {
            for (j in 0 .. s.length - i) {
                if (isPanlidrome(s.slice(j until j + i))) {
                    sum += 1
                }
            }
        }
        return sum
    }
}