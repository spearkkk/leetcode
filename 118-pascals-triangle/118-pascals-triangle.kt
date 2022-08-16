class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 0) {
            return listOf()
        }

        val result: MutableList<List<Int>> = mutableListOf(listOf(1))

        for (i in 2 .. numRows) {
            val row: MutableList<Int> = mutableListOf(result[i - 1 - 1][0])
            for (j in 1 until i - 1) {
                row.add(result[i - 1 - 1][j - 1] + result[i - 1 - 1][j])
            }
            row.add(result[i - 1 - 1][i - 2])
            result.add(row)
        }
        return result
    }
}
