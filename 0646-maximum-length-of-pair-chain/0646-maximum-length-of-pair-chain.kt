class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        val c = Comparator<IntArray> { o1, o2 -> o1[1] - o2[1]}
        val sorted = pairs.toList().sortedWith(c)

        var last = Int.MIN_VALUE
        var cnt = 0

        for (cursor in sorted.indices) {
            val current = sorted[cursor]

            if (last < current[0]) {
                cnt += 1
                last = current[1]
            }

        }

        return cnt
    }
}