class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val board = Array(m + 1) { IntArray(n + 1) }

        for (i in 1 .. m) {
            for (j in 1 .. n) {
                /// 아래와 오른쪽으로만 이동할 수 있기 때문에 매트릭스의 제일 상단과 제일 왼쪽은 갈 수 있는 경로의 개수는 단 하나이다.
                if (i == 1 || j == 1) {
                    board[i][j] = 1
                    continue
                }
                /// 위와 왼쪽에서 오는 경우의 수를 합하면 현재 위치까지 올 수 있는 경로의 수다.
                board[i][j] = board[i - 1][j] + board[i][j - 1]
            }
        }

        return board[m][n]
    }
}
