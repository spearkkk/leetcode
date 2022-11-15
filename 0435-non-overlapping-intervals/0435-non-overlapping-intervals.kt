class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        val comparator: Comparator<IntArray> = Comparator { o1, o2 -> val tmp = o1[0] - o2[0]
            if (tmp == 0) {
                (o1[1] - o1[0]) - (o2[1] - o2[0])
            } else {
                tmp
            }
        }

        intervals.sortWith(comparator)

        var last = -50001
        var cnt = 0

        for (interval in intervals) {
            if (interval[0] < last) {
                cnt += 1
                last = kotlin.math.min(last, interval[1])
                continue
            }
            last = interval[1]
        }
        return cnt
    }
}