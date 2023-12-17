class Solution {
    fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
        val counts = IntArray(n) { 0 }

        var max = -1

        fun bt(cursor: Int, cnt: Int) {
            if (cursor >= requests.size) {
                if (counts.all { it == 0 }) {
                    if (max < cnt) {
                        max = cnt
                    }
                }

                return
            }

            if (requests.size - cursor < counts.maxOfOrNull { kotlin.math.abs(it) }!!) {
                return
            }

            val from = requests[cursor][0]
            val to = requests[cursor][1]

            counts[from] -= 1
            counts[to] += 1
            bt(cursor + 1, cnt + 1)

            counts[from] += 1
            counts[to] -= 1
            bt(cursor + 1, cnt)
        }

        bt(0, 0)

        return max
    }
}