class Solution {
    fun longestPalindrome(s: String): Int {
        val holder = IntArray(58) { 0 }

        for (cur in s) {
            holder[cur - 'A'] += 1
        }

        var result = 0
        /// 문자의 수가 홀수가 있다면 최대 길이에 무조건 1을 더할 수 있다.
        /// 문자의 수가 홀수인 문자들 중에 실제 사용할 수 있는 문자열은 그 중 하나 이다.
        if (holder.find { v -> v % 2 == 1 } != null) {
            result += 1
        }

        /// 문자의 수 중에 홀수를 강제로 내림 해버린다.
        result += holder.filter { v -> v > 1 }.map { v -> (v / 2) * 2 }.sum()

        return result
    }
}
