class Solution {
    fun firstUniqChar(s: String): Int {
        val mark = BooleanArray(s.length) { true }

        for (i in 1 until s.length) {
            for (j in 0 until i) {
                if (s[j] == s[i]) {
                    mark[j] = false
                    mark[i] = false
                    break
                }
            }
        }

        return mark.withIndex().find { indexedValue -> indexedValue.value }?.index ?: -1
    }
}
