class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }

        /// 메트릭스를 초기화하고 지나가면서 값을 넣는다.
        val matrix = Array(numRows) { CharArray((s.length)) { '0' } }

        /// 문자열을 큐형태로 만든다.
        val str: ArrayList<Char> = s.toCharArray().toCollection(ArrayList())

        /// 지나가는 cursor
        var row = 0
        var col = 0

        /// 방향 플래그
        var goingDown = true

        while (str.isNotEmpty()) {
            /// 로우의 상태에 따라 방향 플래그를 갱신한다.
            if (row == numRows - 1) {
                goingDown = false
            }
            if (row == 0) {
                goingDown = true
            }

            /// 매트릭스에 값을 넣는다.
            matrix[row][col] = str.removeAt(0)

            /// 다음 위치로 이동
            if (goingDown) {
                row += 1
            } else {
                row -= 1
                col += 1
            }
        }

        var result = ""
        for (charArray in matrix) {
            for (c in charArray) {
                if (c != '0') {
                    result += c
                }
            }
        }

        return result
    }
}
