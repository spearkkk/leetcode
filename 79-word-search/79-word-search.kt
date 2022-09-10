class Solution {
    private fun seek(board: Array<CharArray>, word: String, cursor: Int, current: Pair<Int, Int>): Boolean {
        if (cursor >= word.length) {
            return true
        }
        if (current.first < 0 || current.first >= board.size || current.second < 0 || current.second >= board[0].size) {
            return false
        }

        if (board[current.first][current.second] != word[cursor]) {
            return false
        }

        val stored = board[current.first][current.second]
        board[current.first][current.second] = '*'

        val result = seek(board, word, cursor + 1, Pair(current.first - 1, current.second))
                || seek(board, word, cursor + 1, Pair(current.first, current.second - 1))
                || seek(board, word, cursor + 1, Pair(current.first + 1, current.second))
                || seek(board, word, cursor + 1, Pair(current.first, current.second + 1))

        board[current.first][current.second] = stored

        return result
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (y in board.indices) {
            for (x in board[y].indices) {
                if (seek(board, word, 0, Pair(y, x))) {
                    return true
                }
            }
        }
        return false
    }
}