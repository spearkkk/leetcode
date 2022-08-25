class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        // edge case
        if (triangle.size == 1) return triangle[0][0]

        // for mutable list
        val copied = mutableListOf<MutableList<Int>>()
        for (tmp in triangle) {
            copied.add(tmp.toMutableList())
        }

        // bottom up
        for (i in (0 until copied.size - 1).reversed()) {
            for (j in 0 .. i) {
                copied[i][j] += kotlin.math.min(copied[i + 1][j], copied[i + 1][j + 1])
            }
        }

        return copied[0][0]
    }
}
