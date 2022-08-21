class Solution {
    private val digits = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

    private fun checkOverflow(a: Int, b: Int): Boolean {
        if (a > Int.MAX_VALUE / 10) {
            return true
        }

        return (Int.MAX_VALUE - b) < a * 10
    }

    private fun checkOverflow2(a: Int, b: Int): Boolean {
        if (a < Int.MIN_VALUE / 10) {
            return true
        }
        return Int.MIN_VALUE + b> a * 10
    }

    fun myAtoi(s: String): Int {
        var positive: Boolean? = null
        var started = false

        var result = 0

        var cursor = 0
        while (cursor < s.length) {
            val currentDigit = s[cursor].toInt()
            val zero = '0'.toInt()

            if (digits.contains(currentDigit - zero)) {

                /// 오버플로우 체크
                if (positive != false && checkOverflow(result, currentDigit - zero)) {
                    return Int.MAX_VALUE
                }

                if (positive == false && checkOverflow2(result, currentDigit - zero)) {
                    return Int.MIN_VALUE
                }

                result = if (positive != false) {
                    result * 10 + (currentDigit - zero)
                } else {
                    (result * 10) - (currentDigit - zero)
                }

                /// 숫자가 시작되었음을 마킹한다.
                started = true
                cursor += 1
                continue
            }

            /// 숫자가 시작되었다면 어떠한 문자도 뒤에 오면 안된다.
            if (started) {
                return result
            }

            if (positive == null && s[cursor] == '-') {
                positive = false
                started = true
                cursor += 1
                continue
            }

            if (positive == null && s[cursor] == '+') {
                positive = true
                started = true
                cursor += 1
                continue
            }

            if (s[cursor] == ' ') {
                cursor += 1
                continue
            }

            return 0
        }

        /// "", "0" 등의 엣지 케이스
        if (result == 0) {
            return result
        }

        return result
    }
}
