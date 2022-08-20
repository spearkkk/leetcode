class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        /// 최대 길이부터 검사한다.
        var length = s.length
        while (length > 1) {

            /// 이번 검사에서 다음에 검사할 길이를 갱신할 것이다.
            var nextLength = 1
            for (cursor in 0 .. s.length - length) {
                
                /// 중복이 없는 문자의 수를 구한다.
                val currentResult = s.slice(cursor until cursor + length).toCharArray().distinct().size
                
                /// 문자의 수가 길이와 맞으면 반환
                if (currentResult == length) {
                    return length
                }

                /// 중복이 없는 문자의 수를 다음 길이로 갱신한다.
                if (nextLength < currentResult) {
                    nextLength = currentResult
                }
            }

            length = nextLength
        }

        return 1
    }
}
