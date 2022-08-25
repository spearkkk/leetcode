class Solution {
    fun addStrings(num1: String, num2: String): String {

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
}