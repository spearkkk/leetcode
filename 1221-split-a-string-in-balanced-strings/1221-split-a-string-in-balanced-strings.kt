class Solution {
    private fun isBalanced(s: String): Boolean {
        var cnt = 0
        for (letter in s) {
            if (letter == 'L') {
                cnt += 1
                continue
            }
            cnt -= 1
        }
        return cnt == 0
    }

    fun balancedStringSplit(s: String): Int {
        var left = 0
        var right = 1

        var result = 0

        while (right < s.length) {
            val tmp = s.substring(left .. right)
            if (isBalanced(tmp)) {
                left = right + 1
                right = left + 1
                result += 1
                continue
            }
            right += 2
        }

        return result
    }
}