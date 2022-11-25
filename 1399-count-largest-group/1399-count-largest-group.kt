class Solution {
    fun countLargestGroup(n: Int): Int {
        val result = IntArray(9 * 4 + 1) { 0 }

        fun sum(num: Int): Int {
            var current = num
            var sum = 0
            while (current / 10 > 0) {
                sum += (current % 10)
                current /= 10
            }
            return sum + current
        }

        for (num in 1 .. n) {
            result[sum(num)] += 1
        }

        var cnt = 0
        var last = 0
        for (cursor in result.indices) {
            if (result[cursor] == last) {
                cnt += 1
                continue
            }
            if (last < result[cursor]) {
                last = result[cursor]
                cnt = 1
            }
        }
        return cnt
    }
}