class Solution {
    fun hammingDistance(x: Int, y: Int): Int {
        var left = x
        var right = y

        var result = 0

        while ( left > 0 || right > 0) {
            if (left.and(1) != right.and(1)) {
                result += 1
            }

            left = left.shr(1)
            right = right.shr(1)
        }

        return result
    }
}