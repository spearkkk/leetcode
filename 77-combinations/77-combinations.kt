class Solution {
    private fun seek(k: Int, start: Int, end: Int, current: MutableList<Int>, result: MutableList<List<Int>>) {
        if (k == current.size) {
            result.add(current.toList())
            return
        }

        for (cursor in start .. end) {
            val next = current.toMutableList()
            next.add(cursor)
            seek(k, cursor + 1, end, next, result)
        }
    }

    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        seek(k, 1, n, mutableListOf(), result)
        return result
    }
}