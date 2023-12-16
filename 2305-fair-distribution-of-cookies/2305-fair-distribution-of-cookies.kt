class Solution {
    fun distributeCookies(cookies: IntArray, k: Int): Int {

        val sum = IntArray(k) { 0 }

        var min = Int.MAX_VALUE
        var max = -1

        fun bt(cursor: Int) {
            if (cursor >= cookies.size) {
                var tmp = 0
                
                val sortedSum = sum.sortedDescending()
                for (i in 1 until k) {
                    tmp += kotlin.math.abs(sortedSum[0] - sortedSum[i])
                }
                
                if (tmp < min) {
                    min = tmp
                    max = sum.max()
                }
                return
            }

            for (i in sum.indices) {
                sum[i] += cookies[cursor]
                bt(cursor + 1)
                sum[i] -= cookies[cursor]
            }
        }

        bt(0)
        return max
    }
}