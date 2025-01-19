class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0

        val mark = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0
        var max = 0

        while (right < s.length) {
            val current = s[right]

            if (mark.containsKey(current)) {
                left = kotlin.math.max(left, mark[current]!! + 1)
            }

            mark[current] = right
            right += 1

            max = kotlin.math.max(max, right - left)
        }
        return max
    }
}