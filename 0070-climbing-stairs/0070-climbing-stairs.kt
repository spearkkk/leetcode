class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 2) {
            return n
        }
        
        val sum = IntArray(n + 1)
        
        sum[1] = 1
        sum[2] = 2

        for (k in 3 .. n) {
            sum[k] = sum[k - 1] + sum[k - 2]
        }
        
        return sum[n]
    }
}