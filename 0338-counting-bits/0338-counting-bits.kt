class Solution {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1) { 0 }

        for (cursor in 1 .. n) {
            result[cursor] = Integer.bitCount(cursor)
        }

        return result
    }
}