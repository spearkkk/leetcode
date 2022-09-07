class Solution {
    private fun search(start: Int, end: Int, matrix: Array<IntArray>, target: Int): Boolean {
        if (start > end) {
            return false
        }
        val middle = start + (end - start) / 2

        val y = middle / matrix[0].size
        val x = middle % matrix[0].size

        if (matrix[y][x] == target) {
            return true
        } else if (matrix[y][x] > target) {
            return search(start, middle - 1, matrix, target)
        }
        return search(middle + 1, end, matrix, target)
    }

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        return search(0, matrix.size * matrix[0].size - 1, matrix, target)
    }
}