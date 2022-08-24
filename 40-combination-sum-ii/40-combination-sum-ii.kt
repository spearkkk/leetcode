class Solution {
    private fun sum(counts: IntArray, start: Int, target: Int, selected: MutableList<Int>, result: MutableSet<List<Int>>) {
        val currentSum = selected.sum()
        if (currentSum == target) {
            result.add(selected)
            return
        }


        /// 현재 값인 start 부터 끝까지 더해본다.
        for (value in start until counts.size) {
            val maximumCount = counts[value]

            /// 더할 때에는 가지고 있는 개수를 활용한다.
            /// 0개를 사용하거나 maximum까지 사용한다.
            for (count in 1 .. maximumCount) {
                /// 실제 사용하기 전에 유효성을 검증을 먼저 한다.
                if (value * count + currentSum > target) {
                    continue
                }
                
                /// 레퍼런스이기 때문에 복사해서 넘겨준다.
                val copied = selected.toMutableList()
                copied.addAll((1 .. count).map { value })
                sum(counts, value + 1, target, copied, result)
            }
        }
    }


    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        /// candidates에 나오는 수에 대한 개수를 저장한다.
        val counts = IntArray(51) { 0 }
        for (candidate in candidates) {
            counts[candidate] += 1
        }
        
        val result = mutableSetOf<List<Int>>()
        /// 개수를 활용하여 target을 구한다.
        sum(counts, 0, target, mutableListOf(), result)
        return result.toList()
    }
}
