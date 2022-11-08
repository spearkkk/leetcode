class Solution {
    fun makeGood(s: String): String {
        fun make(str: String, result: StringBuilder, cursor: Int): StringBuilder {
            if (cursor >= str.length) {
                return result
            }

            if (result.isNotBlank()) {
                val left = result.last()
                val right = str[cursor]
                val gap = left.toInt() - right.toInt()
                if (gap == 32 || gap == -32) {
                    return make(str, result.deleteCharAt(result.length - 1), cursor + 1)
                }
            }
            return make(str, result.append(str[cursor]), cursor + 1)
        }

        return make(s, StringBuilder(), 0).toString()
    }
}