class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val xHolder = mutableSetOf<Int>()
        val yHolder = mutableSetOf<Int>()

        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                if (matrix[y][x] == 0) {
                    xHolder.add(x)
                    yHolder.add(y)

                    for (anotherX in 0 until x) {
                        matrix[y][anotherX] = 0
                    }

                    for (anotherY in 0 until y) {
                        matrix[anotherY][x] = 0
                    }
                }
                if (xHolder.contains(x)) {
                    matrix[y][x] = 0
                }
            }

            if (yHolder.remove(y)) {
                for (x in 0 until  matrix[y].size) {
                    matrix[y][x] = 0
                }
            }
        }
    }
}