class Solution {
    fun addBinary(a: String, b: String): String {
        var result = ""

        var aIndex = a.length - 1
        var bIndex = b.length - 1
        var carry = false

        while (aIndex >= 0 || bIndex >= 0 || carry) {
            /// carry가 있을 경우 1을 추가적으로 더해준다.
            var tmp = if (carry) 1 else 0

            tmp += if (aIndex < 0) 0 else { a[aIndex].toString().toInt() } + if (bIndex < 0) 0 else b[bIndex].toString().toInt()

            carry = tmp / 2 == 1
            result = "${tmp % 2}$result"

            aIndex -= 1
            bIndex -= 1
        }

        return result
    }
}