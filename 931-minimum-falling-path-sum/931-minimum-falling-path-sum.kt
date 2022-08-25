class Solution {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        /// 2번째 열부터 계산한다.
        for (row in 1 until matrix.size) {
            for (column in 0 until matrix[row].size) {
                /// 비로 위, 왼쪽 위, 오른쪽 위에 값을 가져온다.
                /// 최솟값을 찾는 것이기 때문에 접근할 수 없으면 (100 * 100 + 1)으로 설정한다.
                val top = matrix[row - 1][column]
                val leftTop = if (column - 1 < 0) 10001 else matrix[row - 1][column - 1]
                val rightTop = if (column + 1 >= matrix[row].size) 10001 else matrix[row - 1][column + 1]

                matrix[row][column] += kotlin.math.min(kotlin.math.min(top, leftTop), rightTop)
            }
        }

        return matrix.last().min()!!
    }
}
