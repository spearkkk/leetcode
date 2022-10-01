class Solution {
    fun reverseWords(s: String): String {
        val stack = mutableListOf<String>()
        for (split in s.split(' ')) {
            if (split.isNotBlank()) { stack.add(split) }
        }
        return stack.reversed().joinToString(" ")
    }
}