class Solution {
    private fun isPalinDrome(cur: String): Boolean {
        for (i in 0 until cur.length / 2) {
            if (cur[i] != cur[cur.length - i - 1]) {
                return false
            }
        }
        return true
    }

    fun longestPalindrome(s: String): String {
        for (currentLength in s.length downTo 1) {
            var startIndex = 0

            while (startIndex + currentLength <= s.length) {
                val subString = s.slice(startIndex until startIndex + currentLength)
                if (isPalinDrome(subString)) {
                    return subString
                }

                startIndex += 1
            }
        }
        return ""
    }
}













