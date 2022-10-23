class Solution {
    fun isAdditiveNumber(num: String): Boolean {
    if (num.length < 3) return false

    for (i in 0..num.length / 3) {
        val first = num.substring(0, i + 1)
        if (first[0] == '0' && first.length > 1) {
            continue
        }
        for (j in i + 1..num.length - 1) {
            val second = num.substring(i + 1, j + 1)
            if (second[0] == '0' && second.length > 1) {
                continue
            }
            if (valid(num.substring(j + 1),
                first.toLong(), second.toLong())) {
                return true
            }
        }
    }
    return false
}

private fun valid(num: String, first: Long, second: Long): Boolean {
    val sum = first + second
    val str = sum.toString()
    val len = str.length

    if (num.length < len) return false
    if (num.length == len && num == str) return true
    if (num.substring(0, len) == str) {
        return valid(num.substring(len), second, sum)
    }

    return false
}
}