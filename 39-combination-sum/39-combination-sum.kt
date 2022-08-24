class Solution {
    private fun sum(candidates: IntArray, target: Int, start: Int, end: Int, selected: MutableList<Int>, result: MutableList<List<Int>>) {
        val value = selected.sum()
        if (value > target) {
            return
        }

        if (value == target) {
            result.add(selected)
            return
        }

        for (cursor in start .. end) {
            val copied = selected.toMutableList()
            copied.add(candidates[cursor])
            sum(candidates, target, cursor, end, copied, result)
        }

    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        val result = mutableListOf<List<Int>>()
        sum(candidates, target, 0, candidates.size - 1, mutableListOf(), result)
        return result
    }
}