class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val yIndex = matrix.indices.toMutableList()
        val xIndex = IntArray(matrix.size) { 0 }
        var cnt = 0

        val holder = mutableListOf<Int>()
        while (cnt < k) {
            var minValueYIndex = yIndex[0]
            for (cursor in yIndex) {
                val current = matrix[cursor][xIndex[cursor]]
                val min = matrix[minValueYIndex][xIndex[minValueYIndex]]

                if (current < min) {
                    minValueYIndex = cursor
                }
            }

            holder.add(matrix[minValueYIndex][xIndex[minValueYIndex]])

            if (xIndex[minValueYIndex] == matrix[minValueYIndex].size - 1) {
                yIndex.remove(minValueYIndex)
            } else {
                xIndex[minValueYIndex] += 1
            }

            cnt += 1
        }

        return holder.last()
    }
}