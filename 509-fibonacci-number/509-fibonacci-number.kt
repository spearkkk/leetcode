class Solution {
    fun fib(n: Int): Int {
        val fibo = IntArray(31)
        fibo[0] = 0
        fibo[1] = 1
        
        for (i in 2 .. 30) {
            fibo[i] = fibo[i - 1] + fibo[i - 2]
        }

        return fibo[n]
    }
}