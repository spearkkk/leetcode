class Solution {
    private val footprint = mutableSetOf<Pair<Int, Int>>()

    fun numIslands(grid: Array<CharArray>): Int {
        val matrix = Array(grid.size + 1) { BooleanArray(grid[0].size + 1) { false } }

        /// 오른쪽, 아래쪽 계산을 쉽게하기 위해 복사
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                matrix[y][x] = grid[y][x] == '1'
            }
        }

        var result = 0
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                /// 이미 거쳤던 좌표는 스킵
                if (footprint.contains(Pair(y, x))) {
                    continue
                }

                /// 현재 좌표가 0이면 스킵
                if (grid[y][x] == '0') {
                    footprint.add(Pair(y, x))
                    continue
                }

                /// 현재 좌표의 인접한 좌표들 중, 1인 값들을 넣는다.
                val adjacent = mutableListOf(Pair(y, x))

                /// 인접한 좌표들을 조사해서 계속해서 연결되어 있으면 연달아 확인한다.
                while (adjacent.isNotEmpty()) {
                    val (currentY, currentX) = adjacent.removeAt(0)

                    /// 인접한 좌표들이 연결되었을 때에만 값을 넣는다.
                    if (!footprint.contains(Pair(currentY, currentX + 1)) && matrix[currentY][currentX + 1]) {
                        adjacent.add(Pair(currentY, currentX + 1))
                    }
                    if (!footprint.contains(Pair(currentY + 1, currentX)) && matrix[currentY + 1][currentX]) {
                        adjacent.add(Pair(currentY + 1, currentX))
                    }

                    /// 엣지 케이스, 밑에 인접한 값을 검색할 때 왼쪽에 있는 인접한 부분도 같이 봐야한다.
                    if (currentX > 0 && !footprint.contains(Pair(currentY, currentX - 1)) && matrix[currentY][currentX - 1]) {
                        adjacent.add(Pair(currentY, currentX - 1))
                    }
                    if (currentY > 0 && !footprint.contains(Pair(currentY - 1, currentX)) && matrix[currentY - 1][currentX]) {
                        adjacent.add(Pair(currentY - 1, currentX))
                    }

                    /// 인접한 좌표들을 검사하기 때문에 footprint 갱신
                    footprint.add(Pair(currentY, currentX + 1))
                    footprint.add(Pair(currentY + 1, currentX))
                    footprint.add(Pair(currentY, currentX - 1))
                    footprint.add(Pair(currentY - 1, currentX))
                }

                result += 1
            }
        }
        return result
    }
}
