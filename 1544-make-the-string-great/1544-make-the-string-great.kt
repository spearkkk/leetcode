class Solution {
    fun makeGood(s: String): String {
        fun make(str: String, result: String, cursor: Int): String {
            if (cursor >= str.length) {
                return result
            }

            if (result.isNotBlank()) {
                val left = result.last()
                val right = str[cursor]
                val gap = left.toInt() - right.toInt()
                if (gap == 32 || gap == -32) {
                    return make(str, result.slice(0 until result.length - 1), cursor + 1)
                }
            }
            return make(str, result + str[cursor], cursor + 1)
        }

        return make(s, "", 0)
    }
}