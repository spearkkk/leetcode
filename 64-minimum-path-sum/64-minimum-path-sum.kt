class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 && j == 0) {
                    continue
                } else if (i == 0) {
                    grid[0][j] += grid[0][j - 1]
                } else if (j == 0) {
                    grid[i][0] += grid[i - 1][0]
                } else {
                    /// 최솟값을 구하는 것이기 때문에 상단과 왼쪽의 경로 중 최솟값을 선택한다.
                    grid[i][j] += kotlin.math.min(grid[i - 1][j], grid[i][j - 1])
                }
            }
        }

        return grid[m - 1][n - 1]
    }
}
