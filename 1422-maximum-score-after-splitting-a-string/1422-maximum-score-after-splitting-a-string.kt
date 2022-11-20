class Solution {
    fun maxScore(s: String): Int {
        var oneCnt = 0
        var cursor = 0

        while (cursor < s.length) {
            if (s[cursor] - '0' == 1) {
                oneCnt += 1
            }

            cursor += 1
        }

        var zeroCnt = 0
        var max = 0
        cursor = 0
        while (cursor < s.length - 1) {
            if (s[cursor] - '0' == 0) {
                zeroCnt += 1
            }
            if (s[cursor] - '0' == 1) {
                oneCnt -= 1
            }
            max = kotlin.math.max(max, zeroCnt + oneCnt)
            cursor += 1
        }

        return max
    }
}