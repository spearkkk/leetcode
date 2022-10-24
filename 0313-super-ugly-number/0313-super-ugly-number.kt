class Solution {
    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val uglyNumbers = LongArray(n)
        uglyNumbers[0] = 1

        val uglyToCursor = mutableMapOf<Int, Int>()
        for (prime in primes) {
            uglyToCursor[prime] = 0
        }

        val footprint = mutableSetOf(1L)

        var cursor = 1
        while (cursor < n) {
            val uglyToMin: Pair<Int, Long> = uglyToCursor.map { Pair(it.key, it.key * uglyNumbers[it.value]) }.minBy { it.second }!!
            uglyToCursor[uglyToMin.first] = uglyToCursor[uglyToMin.first]!! + 1

            if (footprint.contains(uglyToMin.second)) {
                continue
            }

            uglyNumbers[cursor] = uglyToMin.second
            footprint.add(uglyToMin.second)
            cursor += 1
        }

        return uglyNumbers[n - 1].toInt()
    }
}