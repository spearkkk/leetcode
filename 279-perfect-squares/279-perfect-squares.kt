class Solution {
    /**
     *
     * 9: 9 -> 1
     * 4: 4 -> 1
     * 1: 1 -> 1
     *
     * 10: 9 + 1 -> 2, 4 + 4 + 1 + 1 -> 4
     * 8: 4 + 4 -> 2
     * 5: 4 + 1 -> 2
     * 2: 1 + 1 -> 2
     *
     * 12: 9 + 1 + 1 + 1 -> 4, 4 + 4 + 4 -> 3
     * 11: 9 + 1 + 1 -> 3, 4 + 4 + 1 + 1 + 1 -> 5
     * 6: 4 + 1 + 1 -> 3
     * 3: 1 + 1 + 1 -> 3
     *
     * 7: 4 + 1 + 1 + 1 -> 4
     *
     *
     */

    private fun isSquare(n: Int): Boolean {
        val tmp = kotlin.math.sqrt(n.toDouble()).toInt()
        return tmp * tmp == n
    }

    fun numSquares(n: Int): Int {
        val numberToCount: MutableMap<Int, Int> = mutableMapOf(Pair(1, 1))
        val firstTier: MutableList<Int> = mutableListOf(1)

        for (i in 2 .. n) {
            if (isSquare(i)) {
                numberToCount[i] = 1
                firstTier.add(0, i) // 제곱근이 정수이면 first tier에 넣는다.
                continue
            }
            // i에 대해 각각의 first tier에 있는 값을 선택했을 때의 최솟값을 가져온다.
            numberToCount[i] = firstTier.map { (numberToCount[i - it] ?: 0) + 1 }.min() ?: 0
        }
        return numberToCount[n] ?: 0
    }
}
