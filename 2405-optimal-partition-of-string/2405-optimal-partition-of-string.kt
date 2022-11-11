class Solution {
    fun partitionString(s: String): Int {
        if (s.isEmpty()) return 0

        val set = mutableSetOf(s[0])
        var cursor = 1
        var count = 0
        while (cursor < s.length) {
            val current = s[cursor]

            if (set.contains(current)) {
                count += 1

                set.clear()
            }
            set.add(current)
            cursor += 1
        }

        return count + 1
    }
}