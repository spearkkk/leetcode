class Solution {
    private fun probe(k: Int, n: Int, cursor: Int, combination: List<Int>, result: MutableList<List<Int>>) {
        if (k == 0) {
            if (n == combination.sum()) {
                result.add(combination)
            }
            return
        }

        if (cursor > n || k * cursor > n || cursor > 9) {
            return
        }

        val nextCombination = combination.toMutableList()
        nextCombination.add(cursor)
        probe(k - 1, n, cursor + 1, nextCombination, result)
        probe(k, n, cursor + 1, combination, result)
    }

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        probe(k, n, 1, listOf(), result)
        return result
    }
}