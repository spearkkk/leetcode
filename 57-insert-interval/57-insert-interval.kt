class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val footprint = IntArray(100000 + 1) { -1 }

        for (interval in intervals) {
            if (footprint[interval[0]] < interval[1]) {
                footprint[interval[0]] = interval[1]
            }
        }
        if (footprint[newInterval[0]] <  newInterval[1]) {
            footprint[newInterval[0]] = newInterval[1]
        }

        val result = mutableListOf<IntArray>()

        var cursor = 0
        while (cursor < footprint.size) {
            if (footprint[cursor] != -1) {
                val start = cursor
                var lastIndex = footprint[cursor]

                while (cursor <= lastIndex) {
                    if (footprint[cursor] != -1 && footprint[cursor] > lastIndex) {
                        lastIndex = footprint[cursor]
                    }
                    cursor += 1
                }

                result.add(intArrayOf(start, lastIndex))
            } else {
                cursor += 1
            }
        }

        return result.toTypedArray()
    }
}
