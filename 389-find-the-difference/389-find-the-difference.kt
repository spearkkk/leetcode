class Solution {
    fun findTheDifference(s: String, t: String): Char {
        val holder = IntArray(26)

        for (i in s.indices) {
            holder[s[i] - 'a'] += 1
            holder[t[i] - 'a'] -= 1
        }

        holder[t.last() - 'a'] -= 1

        return (holder.withIndex().find { indexedValue -> indexedValue.value == -1 }!!.index + 97).toChar()
    }
}