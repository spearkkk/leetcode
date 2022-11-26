class Solution {
    fun findLucky(arr: IntArray): Int {
        val mark = IntArray(500 + 1) { 0 }

        for (idx in arr) {
            mark[idx] += 1
        }

        var max = -1
        for (cursor in 1 .. arr.size) {
            if (mark[cursor] == cursor) {
                max = kotlin.math.max(max, cursor)
            }
        }

        return max
    }
}