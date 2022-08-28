class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        var x = 0
        var y = mat.size - 1

        while(true) {
            if (x == mat[0].size) {
                break
            }

            var tmpX = x
            var tmpY = y

            val holder = mutableListOf<Int>()

            while (tmpX <= mat[0].size - 1 && tmpY <= mat.size - 1) {
                holder.add(mat[tmpY][tmpX])
                tmpX += 1
                tmpY += 1
            }

            val tmp22 = holder.sorted().toMutableList()

            var tmpX2 = x
            var tmpY2 = y

            while (tmpX2 <= mat[0].size - 1 && tmpY2 <= mat.size - 1) {
                mat[tmpY2][tmpX2] = tmp22.removeAt(0)
                tmpX2 += 1
                tmpY2 += 1
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
