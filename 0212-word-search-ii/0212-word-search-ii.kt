class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {

        fun exist(board: Array<CharArray>, word: String): Boolean {
            val n = board.size
            val m = board[0].size
    
            fun bt(cursor: Int, y: Int, x: Int): Boolean {
                if (cursor >= word.length) {
                    return true
                }
    
                // 현재 좌표를 체크한다.
                if (y < 0 || y >= n || x < 0 || x >= m) {
                    return false
                }
    
                if (board[y][x] != word[cursor]) {
                    return false
                }
    
                // 사용했는지 마킹을 다른 배열이 아니라 문자를 바꾸어서 마킹한다.
                val tmp = board[y][x]
                board[y][x] = '*'
    
                val result = bt(cursor + 1, y + 1, x)
                    || bt(cursor + 1, y - 1, x)
                    || bt(cursor + 1, y, x + 1)
                    || bt(cursor + 1, y, x - 1)
    
                board[y][x] = tmp
    
                return result
            }
    
    
    
            for (y in board.indices) {
                for (x in board[y].indices) {
                    if (bt(0, y, x)) {
                        return true
                    }
                }
            }
            return false
    
        }
        
        val answers = mutableListOf<String>()
        for (word in words) {
            if (exist(board, word)) {
                answers.add(word)
            }
        }
        
        return answers
    }
}