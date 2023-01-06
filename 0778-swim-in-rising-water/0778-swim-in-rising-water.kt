class Solution {
    // bfs + hash or
    // https://youtu.be/f1HUWepwp8g
    // priorty queue
    fun swimInWater(grid: Array<IntArray>): Int {
        val x = grid.size - 1
        val y = grid[0].size - 1
        val pq: java.util.PriorityQueue<IntArray> = java.util.PriorityQueue { o1, o2 -> o1[0] - o2[0]}
        pq.offer(intArrayOf(grid[x][y], x, y))

        val neighbors = listOf(Pair(0, -1), Pair(0, 1), Pair(-1, 0), Pair(1, 0))

        var t = 0

        while(pq.isNotEmpty()) {
            val current = pq.remove()
            val currentLevel = current[0]
            val currentX = current[1]
            val currentY = current[2]

            t = kotlin.math.max(t, currentLevel)

            if (currentX == 0 && currentY == 0) {
                return t
            }

            for (neighbor in neighbors) {
                val nextX = currentX + neighbor.first
                val nextY = currentY + neighbor.second

                if (nextX < 0 || nextX > x || nextY < 0 || nextY > y || grid[nextX][nextY] < 0) {
                    continue
                }
                pq.offer(intArrayOf(grid[nextX][nextY], nextX, nextY))
                grid[nextX][nextY] = -1
            }
        }
        return t
    }
}