class Solution {
    /**
     *
     *
     * 02468
     * 13579
     *
     * 3 * 4
     * 10 -> 5
     * 0 4 8
     * 13579
     * 2 6
     *
     * 4 * 3
     * 10 -> 4
     * 0  6
     * 1 57
     * 24 8
     * 3  9
     *
     * 5 * 3
     * 10 -> 4
     * 0   8  (5-1) * 0 + 0                 (5-1) * 2 + 0                           (5-1) * 4 + 0
     * 1  79  (5-1) * 0 + 1, (5-1) * 1 + 3, (5-1) * 2 + 1, (5-1) * 3 + 3 (1, n - 2)
     * 2 6    (5-1) * 0 + 2, (5-1) * 1 + 2, (5-1) * 2 + 2, (5-1) * 3 + 2 (2)
     * 35     (5-1) * 0 + 3, (5-1) * 1 + 1, (5-1) * 2 + 3, (5-1) * 3 + 1 (n - 2, 1)
     * 4      (5-1) * 0 + 4,                (5-1) * 2 + 4
     */
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }

        val matrix = Array(numRows) { CharArray((s.length)) { '0' } }
        val str: ArrayList<Char> = s.toCharArray().toCollection(ArrayList())

        var row = 0
        var col = 0

        var goingDown = true

        // 6
        // 5

        while (str.isNotEmpty()) {
            if (row == numRows - 1) {
                goingDown = false
            }
            if (row == 0) {
                goingDown = true
            }

            matrix[row][col] = str.removeAt(0)

            if (goingDown) {
                row += 1
            } else {
                row -= 1
                col += 1
            }
        }

        var result = ""
        for (row in matrix) {
            for (c in row) {
                if (c != '0') {
                    result += c
                }
            }
        }

        return result
    }
}
