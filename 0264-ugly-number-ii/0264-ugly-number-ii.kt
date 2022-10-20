
class Solution {
    fun nthUglyNumber(n: Int): Int {
        // edge case
        if (n < 7) {
            return n
        }
        
        var cursor2 = 0
        var cursor3 = 0
        var cursor5 = 0
        var ugly2: Int
        var ugly3: Int
        var ugly5: Int

        val ugly = IntArray(n) { 0 }

        ugly[0] = 1
        
        for (cursor in 1 until n) {
            ugly2 = ugly[cursor2] * 2
            ugly3 = ugly[cursor3] * 3
            ugly5 = ugly[cursor5] * 5
            ugly[cursor] = minOf(ugly2, ugly3, ugly5)
            if (ugly2 == ugly[cursor]) {
                cursor2 += 1
            }
            if (ugly3 == ugly[cursor]) {
                cursor3 += 1
            }
            if (ugly5 == ugly[cursor]) {
                cursor5 += 1
            }

        }
        return ugly[n - 1]
    }
}