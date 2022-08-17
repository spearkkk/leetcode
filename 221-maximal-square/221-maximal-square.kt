class Solution {
    // area 값을 저장하지 않고 정사각형의 한 변의 길이를 저장한다.
    fun maximalSquare(matrix: Array<CharArray>): Int {
        var max = 0

        val memoization: Array<IntArray> = Array(matrix.size) { IntArray( matrix[0].size ) { 0 } }

        /// char -> int, 초기화
        for (cursor in matrix.indices) {
            memoization[cursor] = matrix[cursor].map{ it.toInt() - 48 }.toIntArray()
        }

        /// 첫번째 열을 검사한다.
        for (cursor in matrix.indices) {
            if (memoization[cursor][0] == 1) {
                max = 1
                break
            }
        }

        /// 첫번째 행을 검사한다.
        for (cursor in matrix[0].indices) {
            if (memoization[0][cursor] == 1) {
                max = 1
                break
            }

        }

        for (row in 1 until matrix.size) {
            for (column in 1 until matrix[row].size) {
                val self = memoization[row][column]
                val leftTop = memoization[row - 1][column - 1]
                val leftBottom = memoization[row][column - 1]
                val rightTop = memoization[row - 1][column]

                /// 대각선, 위, 왼쪽을 봤을 때, 0이 존재하면 사각형을 만들 수 없다.
                if (self == 0 || rightTop == 0 || leftBottom == 0 || leftTop == 0) {
                    // edge case, 현재 자기 자신이 1이면 max는 1이다.
                    if (self == 1) {
                        if (max < self) {
                            max = self
                        }
                    }
                    continue
                }
                
                /// 주변의 최저 길이를 가져온다.
                val minimum = kotlin.math.min(kotlin.math.min(rightTop, leftTop), leftBottom) + 1
                if (minimum > max) {
                    max = minimum
                }
                memoization[row][column] = minimum
            }
        }
        return max * max
    }
}
