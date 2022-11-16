class Solution {
    fun maxTurbulenceSize(arr: IntArray): Int {

        // flag, true needs small one
        fun check(cursor: Int, cnt: Int, flag: Boolean, last: Int): Int {
            if (cursor >= arr.size) {
                return cnt
            }

            if (flag && last > arr[cursor]) {
                return check(cursor + 1, cnt + 1, false, arr[cursor])
            }

            if (!flag && last < arr[cursor]) {
                return check(cursor + 1, cnt + 1, true, arr[cursor])
            }

            return cnt
        }

        var max = 0
        for (cursor in arr.indices) {
            max = kotlin.math.max(max, check(cursor, 0, true, 1000000000 + 1))
            max = kotlin.math.max(max, check(cursor, 0, false, -1))
        }
        return max
    }
}