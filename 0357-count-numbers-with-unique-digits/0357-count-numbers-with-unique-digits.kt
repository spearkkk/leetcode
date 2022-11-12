class Solution {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        if (n > 10) {
            return countNumbersWithUniqueDigits(10)
        }

        val mark = BooleanArray(10) { false }

        fun count(num: Int, max: Int): Int {
            var count = 0
            if (num < max) {
                count += 1
            } else {
                return count
            }

            for (cursor in 0 .. 9) {
                if (mark[cursor]) {
                    continue
                }

                mark[cursor] = true
                count += count(num * 10 + cursor, max)
                mark[cursor] = false
            }
            return count
        }

        var max = 1
        for (ignore in 1 .. n) {
            max *= 10
        }
        var count = 1

        for (cursor in 1 .. 9) {
            mark[cursor] = true
            count += count(cursor, max)
            mark[cursor] = false
        }
        return count
    }
}