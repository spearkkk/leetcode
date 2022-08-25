class Solution {
    fun climbStairs(n: Int): Int {
        val count: MutableList<Int> = MutableList(46) { 0 }
        
        /// 1까지 가는 경우의 수
        count.add(1, 1)
        /// 2까지 가는 경우의 수
        count.add(2, 2)

        for (i in 3 .. n) {
            /// i - 2는 2계단을 올라 올 수 있기 때문에 더한다.
            /// i - 1는 1계단을 올라 올 수 있기 때문에 더한다.
            count[i] = count[i - 2] + count[i - 1]
        }

        return count[n]
    }
}
