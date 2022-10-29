class Solution {
    fun integerBreak(n: Int): Int {
        val results = IntArray(n + 1) { 0 }
        results[1] = 1
        results[2] = 1

        for (cursor in 3 .. n) {
            var max = cursor - 1
            for (left in 2 .. cursor / 2) {
                val candidate = left * if ((cursor - left) > results[cursor - left]) cursor - left else results[cursor - left]
                if (candidate > max) {
                    max = candidate
                }
            }
            results[cursor] = max
        }

        return results[n]
    }
}