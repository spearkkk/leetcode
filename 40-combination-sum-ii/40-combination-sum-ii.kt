class Solution {
    private fun sum(counts: IntArray, start: Int, target: Int, selected: MutableList<Int>, result: MutableSet<List<Int>>) {
        val currentSum = selected.sum()
        if (currentSum == target) {
            result.add(selected)
            return
        }


        for (value in start until counts.size) {
            val maximumCount = counts[value]

            for (count in 1 .. maximumCount) {
                if (value * count + currentSum > target) {
                    continue
                }
                val copied = selected.toMutableList()
                copied.addAll((1 .. count).map { value })
                sum(counts, value + 1, target, copied, result)
            }
        }
    }


    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val counts = IntArray(51) { 0 }
        for (candidate in candidates) {
            counts[candidate] += 1
        }
        val result = mutableSetOf<List<Int>>()
        sum(counts, 0, target, mutableListOf(), result)
        return result.toList()
    }
}
