class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val footprint = IntArray(10000 + 1) { -1 }

        /// start 위치에 end 위치를 기록하는데, 
        /// 동일한 start에는 제일 큰 end 위치를 기록한다.
        for (interval in intervals) {
            if (footprint[interval[0]] < interval[1]) {
                footprint[interval[0]] = interval[1]
            }
        }

        val result = mutableListOf<IntArray>()

        var cursor = 0
        while (cursor < footprint.size) {
            
            /// start 위치에 end 위치가 있는 경우에 검사를 시작한다.
            if (footprint[cursor] != -1) {
                val start = cursor
                var lastIndex = footprint[cursor]

                /// start와 end 위치 사이를 돌며 검사를한다.
                /// 검사를 할 때, 중간에 있는 start의 end 위치가 기존의 end 위치보다 크면 변경한다. <- 오버랩
                while (cursor <= lastIndex) {
                    if (footprint[cursor] != -1 && footprint[cursor] > lastIndex) {
                        lastIndex = footprint[cursor]
                    }
                    cursor += 1
                }

                /// 검사가 끝나면 인터벌을 넣는다.
                result.add(intArrayOf(start, lastIndex))
            } else {
                cursor += 1
            }
        }

        return result.toTypedArray()
    }
}
