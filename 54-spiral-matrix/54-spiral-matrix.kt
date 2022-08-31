class Solution {
    private fun getNextPosition(direction: Int, currentPosition: Pair<Int, Int>): Pair<Int, Int> {
        return when (direction) {
            0 -> Pair(currentPosition.first, currentPosition.second + 1)
            1 -> Pair(currentPosition.first + 1, currentPosition.second)
            2 -> Pair(currentPosition.first, currentPosition.second - 1)
            3 -> Pair(currentPosition.first - 1, currentPosition.second)
            else -> Pair(0, 0) // not reached
        }
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        /// 0: right, 1: down: 2: left, 3: up
        var direction = 0

        val footprint = mutableSetOf(Pair(0, 0))
        var current = Pair(0, 0)
        var count = 1

        while (true) {
            if (count == matrix.size * matrix[0].size) {
                break
            }

            val candidate = getNextPosition(direction, current)

            if (footprint.contains(candidate) || candidate.first < 0 || candidate.first >= matrix.size
                || candidate.second < 0 || candidate.second >= matrix[0].size
            ) {
                direction = (direction + 1) % 4
                continue
            }

            footprint.add(candidate)
            count += 1
            current = candidate
        }

        return footprint.map { matrix[it.first][it.second] }
    }
}
