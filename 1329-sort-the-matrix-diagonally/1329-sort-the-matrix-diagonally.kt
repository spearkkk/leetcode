class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        var x = 0
        var y = mat.size - 1

        while(true) {
            if (x == mat[0].size) {
                break
            }

            var leftRightCursor = x
            var bottomTopCursor = y

            val values = mutableListOf<Int>()

            while (leftRightCursor <= mat[0].size - 1 && bottomTopCursor <= mat.size - 1) {
                values.add(mat[bottomTopCursor][leftRightCursor])
                leftRightCursor += 1
                bottomTopCursor += 1
            }

            val sortedValues = values.sorted().toMutableList()

            var leftRightCursor2nd = x
            var bottomTopCursor2nd = y

            while (leftRightCursor2nd <= mat[0].size - 1 && bottomTopCursor2nd <= mat.size - 1) {
                mat[bottomTopCursor2nd][leftRightCursor2nd] = sortedValues.removeAt(0)
                leftRightCursor2nd += 1
                bottomTopCursor2nd += 1
            }

            if (y != 0) {
                y -= 1
            } else {
                x += 1
            }
        }


        return mat
    }
}
