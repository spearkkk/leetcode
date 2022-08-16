class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size

        for (i in 0 until m) {
            for (j in 0 until n) {
                /// 갈 수 없는 곳으로 마킹이 되어 있다면 경로의 수를 0으로 업데이트하고 끝을 낸다.
                /// 0으로 업데이트 해야 이후의 장소에서 해당 값을 참조할 수 있다.
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0
                    continue
                }

                if (i == 0 && j == 0) {
                    obstacleGrid[0][0] = 1
                } else if (i == 0) {
                    obstacleGrid[0][j] = obstacleGrid[0][j - 1]
                } else if (j == 0) {
                    obstacleGrid[i][0] = obstacleGrid[i - 1][0]
                } else {
                    obstacleGrid[i][j] =  obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
                }
            }
        }

        return obstacleGrid[m - 1][n - 1]
    }
}
