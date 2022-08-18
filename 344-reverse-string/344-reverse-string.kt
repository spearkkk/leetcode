class Solution {
    fun reverseString(s: CharArray): Unit {
        for (cursor in 0 until (s.size / 2)) {
            val tmp = s[cursor]
            s[cursor] = s[s.size - 1 - cursor]
            s[s.size - 1 - cursor] = tmp
        }
    }
}