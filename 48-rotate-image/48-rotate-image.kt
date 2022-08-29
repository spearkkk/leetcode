class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {

        var x = 0


        val footprint = mutableListOf<Int>()
        while (x < matrix.size) {
            var y = matrix.size - 1

            while (y >= 0) {
                footprint.add(matrix[y][x])

                y -= 1
            }

            x += 1
        }

        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                matrix[y][x] = footprint.removeAt(0)
            }
        }
    }
}
