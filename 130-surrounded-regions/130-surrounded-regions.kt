class Solution {
    private val footprint = mutableSetOf<Pair<Int, Int>>()

    private fun tryMark(board: Array<CharArray>, y: Int, x: Int, holder: MutableList<Pair<Int, Int>>): Boolean {
        footprint.add(Pair(y, x))
        if (y ==0 || y == board.size - 1 || x == 0 || x == board[y].size - 1) {
            if (board[y][x] == 'O') {
                return false
            }
            return true
        }

        if (board[y][x] == 'X') {
            return true
        }

        board[y][x] = 'X'
        holder.add(Pair(y, x))

        val flag = tryMark(board, y - 1, x, holder) && tryMark(board, y + 1, x, holder) && tryMark(board, y, x - 1, holder) && tryMark(board, y, x + 1, holder)
        if (!flag) {
            while (holder.isNotEmpty()) {
                val tmp = holder.removeAt(0)
                board[tmp.first][tmp.second] = 'O'
            }
        }
        return flag
    }

    fun solve(board: Array<CharArray>): Unit {
        if (board.size <= 2 || board[0].size <= 2) {
            return
        }

        for (y in 1 until board.size - 1) {
            for (x in 1 until board[y].size - 1) {
                if (footprint.contains(Pair(y, x)) || board[y][x] == 'X') {
                    continue
                }

                tryMark(board, y, x, mutableListOf())
            }
        }
    }
}