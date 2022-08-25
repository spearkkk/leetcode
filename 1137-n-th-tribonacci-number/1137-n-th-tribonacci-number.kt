class Solution {
    fun tribonacci(n: Int): Int {
        val holder = IntArray(37+ 1)

        holder[0] = 0
        holder[1] = 1
        holder[2] = 1

        for (i in 3 .. n) {
            holder[i] = holder[i - 3] + holder[i - 2] + holder[i - 1]
        }

        return holder[n]
    }
}