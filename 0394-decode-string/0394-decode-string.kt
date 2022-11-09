class Solution {
    fun decodeString(s: String): String {
        val stack = mutableListOf(Pair(1, ""))
        var cursor = 0
        var k = 0
        while (cursor < s.length) {
            if (s[cursor].isDigit()) {
                k = k * 10 + s[cursor].toInt() - '0'.toInt()
            } else if (s[cursor] == '[') {
                stack.add(Pair(k, ""))
                k = 0
            } else if (s[cursor] == ']') {
                val removed = stack.removeAt(stack.size - 1)
                val last = stack.last()
                stack[stack.size - 1] = Pair(last.first, last.second + (1 .. removed.first).joinToString("") { removed.second })
            } else {
                val last = stack.last()
                stack[stack.size - 1] = Pair(last.first, last.second + s[cursor])
            }

            cursor += 1
        }

        return stack.first().second
    }
}