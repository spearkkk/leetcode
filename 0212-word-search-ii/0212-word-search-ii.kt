class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        data class TrieNode(var word: String = "", val children: MutableMap<Char, TrieNode> = mutableMapOf())

        val root = TrieNode()
        for (word in words) {
            var cursor = root

            for (c in word.toCharArray()) {
                if (!cursor.children.contains(c)) {
                    cursor.children[c] = TrieNode()
                }
                cursor = cursor.children[c]!!
            }

            cursor.word = word
        }

        val dirY = intArrayOf(0, 1, 0, -1)
        val dirX = intArrayOf(1, 0, -1, 0)

        val n = board.size
        val m = board[0].size

        val answers = mutableListOf<String>()

        fun bt(y: Int, x: Int, parentCursor: TrieNode) {
            val currentChar = board[y][x]
            val cursor = parentCursor.children[currentChar]!!

            if (cursor.word.isNotEmpty()) { // found, remove it to block duplicated
                answers.add(cursor.word)
                cursor.word = ""
            }

            board[y][x] = '*' // marking

            for (i in 0 until 4) {
                val ny = y + dirY[i]
                val nx = x + dirX[i]

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue
                }

                if (cursor.children.contains(board[ny][nx])) {
                    bt(ny, nx, cursor)
                }
            }

            board[y][x] = currentChar // un-marking

            if (cursor.children.isEmpty()) {
                parentCursor.children.remove(currentChar) // 이미 이 하위의 자식들은 다 확인이 끝났으니 제거해버린다.
            }
        }

        for (y in 0 until n) {
            for (x in 0 until m) {
                val currentChar = board[y][x]
                if (root.children.contains(currentChar)) {
                    bt(y, x, root)
                }
            }
        }

        return answers
    }
}

