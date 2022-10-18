class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for (y in matrix.indices) {
            if (matrix[y][0] > target) {
                break
            }
            for (x in matrix[y].indices) {
                if (matrix[y][x] == target) {
                    return true
                }

                if (matrix[y][x] > target) {
                    break
                }
            }
        }
        return false
    }
}