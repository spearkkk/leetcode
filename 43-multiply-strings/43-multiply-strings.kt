class Solution {
    private fun add(num1: String, num2: String): String {
        val cur = if (num1.length > num2.length) num1.length else num2.length
        var result = ""
        var carry = 0

        for (i in (0 until cur)) {
            val left = if (num1.length > i) num1[num1.length - 1 - i].toInt() - 48 else 0
            val right = if (num2.length > i) num2[num2.length - 1 - i].toInt() - 48 else 0

            val sum = carry + left + right
            carry = sum / 10

            result = "${sum % 10}$result"
        }


        return if (carry > 0 ) "$carry$result" else result
    }

    fun multiply(num1: String, num2: String): String {
        var leftCursor = num1.length - 1
        var base = 0
        var result = "0"

        while (leftCursor >= 0) {
            var rightCursor = num2.length - 1
            
            var carry = 0
            var tmpResult = ""

            while (rightCursor >= 0) {
                val left = num1[leftCursor].toInt() - '0'.toInt()
                val right = num2[rightCursor].toInt() - '0'.toInt()

                val tmp = left * right + carry
                carry = tmp / 10

                tmpResult = "${tmp % 10}$tmpResult"

                rightCursor -= 1
            }
            
            /// base에 따라 옆에 0을 붙여준다.
            tmpResult = if (carry > 0 ) {
                "$carry$tmpResult${(0 until base).map { '0' }.joinToString("")}"
            } else {
                "$tmpResult${(0 until base).map { '0' }.joinToString("")}"
            }
            
            /// 곱한 결과를 다 더한다.
            result = add(result, tmpResult)
            
            base += 1
            leftCursor -= 1
        }

        /// 엣지 케이스 "0000"같은 경우 "0"으로 반환한다.
        return if (result.startsWith("0")) "0" else result
    }
}
