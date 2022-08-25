class Solution {
    private fun getCountForBase(n: Int, base: Int): Int {
        if (n / base == 0) {
            return 0
        }

        if (n % base == 0) {
            return 1 + getCountForBase(n / base, base)
        }
        return 0
    }

    /**
     * 2, 5의 개수 찾기
     * 2로 나눈 몫이 2의 개수가 아니라,
     * 2의 sqrt 값이 2의 개수임.
     */
    fun trailingZeroes(n: Int): Int {
        var count2 = 0
        var count5 = 0

        for (i in 1 .. n) {
            count2 += getCountForBase(i, 2)
            count5 += getCountForBase(i, 5)
        }

        if (count2 < count5) {
            return count2
        }
        return count5
    }
}