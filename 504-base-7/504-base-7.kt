class Solution {
    fun convertToBase7(num: Int): String {
        val flg = num < 0
        var left: Int = if (num < 0) num * -1 else num
        var right = 1

        while (Int.MAX_VALUE > right * 7L && left > right) {
            right *= 7
        }

        var result = ""
        while (right >= 7) {
            val tmp = left / right
            if (tmp > 0) {
                left -= right * tmp
                result += tmp
            } else if (result.isNotBlank()){
                result += "0"
            }
            right /= 7
        }
        return if (flg) "-$result$left" else result + left
    }
}