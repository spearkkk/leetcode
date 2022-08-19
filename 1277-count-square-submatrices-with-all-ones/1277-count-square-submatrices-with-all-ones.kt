class Solution {
    fun countSquares(matrix: Array<IntArray>): Int {
        val holder = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) { 0 } }

        /// 초기화
        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                holder[y + 1][x + 1] = matrix[y][x]
            }
        }

        /// 매트릭스의 최대 사각형 개수 채워가기
        for (y in 1 until holder.size) {
            for (x in 1 until holder[y].size) {
                
                val cur = holder[y][x]
                if (cur == 0) {
                    continue
                }

                val diagonal = holder[y - 1][x - 1]
                val left = holder[y][x - 1]
                val top = holder[y - 1][x]

                val min = Math.min(Math.min(diagonal, left), top)
                if (min == 0) {
                    continue
                }

                holder[y][x] = 1 + min
            }
        }

        /// 개수 다 더하기
        var sum = 0
        for (y in 1 until holder.size) {
            for (x in 1 until holder[y].size) {
                sum += holder[y][x]
            }
        }


        return sum
    }
}