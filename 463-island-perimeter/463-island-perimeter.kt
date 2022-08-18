class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }

        val copied = Array(grid.size + 2) { IntArray(grid[0].size + 2) { 0 } }

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                copied[i + 1][j + 1] = grid[i][j]
            }
        }

        var countOfBar = 0
        var countOfSurrounded = 0

        for (i in 1 until copied.size - 1) {
            for (j in 1 until copied[i].size - 1) {
                if (copied[i][j] == 1) {
                    countOfBar += 4
                    if (copied[i - 1][j] == 1) {
                        countOfSurrounded += 1
                    }
                    if (copied[i][j - 1] == 1) {
                        countOfSurrounded += 1
                    }
                    if (copied[i + 1][j] == 1) {
                        countOfSurrounded += 1
                    }
                    if (copied[i][j + 1] == 1) {
                        countOfSurrounded += 1
                    }
                }
            }
        }

        return countOfBar - countOfSurrounded
    }
}