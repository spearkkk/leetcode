class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {

        val footprint = mutableListOf<Int>()
        for (x in matrix.indices) {
            for (y in matrix.size - 1 downTo 0) {
                footprint.add(matrix[y][x])
            }
        }

        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                matrix[y][x] = footprint.removeAt(0)
            }
        }
    }
}
