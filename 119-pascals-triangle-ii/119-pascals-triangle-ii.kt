class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 0) {
            return listOf()
        }

        val result: MutableList<List<Int>> = mutableListOf(listOf(1))

        for (currentRow in 2 .. numRows) {
            /// 현재 current row 에서 상위 row를 가기 위해 -1
            /// index로 접근해야하기 때문에 -1
            val upperRowIndex = currentRow - 1 - 1

            val row: MutableList<Int> = mutableListOf(result[upperRowIndex][0])
            for (j in 1 until currentRow - 1) {
                row.add(result[upperRowIndex][j - 1] + result[upperRowIndex][j])
            }
            row.add(result[upperRowIndex][currentRow - 2])
            result.add(row)
        }
        return result
    }

    fun getRow(rowIndex: Int): List<Int> {
        return generate(rowIndex + 1).get(rowIndex)
    }
}