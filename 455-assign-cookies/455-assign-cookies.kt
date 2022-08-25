class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sortDescending()
        s.sortDescending()

        var footprint = -1
        var sum = 0

        /// 제일 큰 사이즈 쿠기부터 루프를 돈다.
        for (cur in s) {
            /// 제일 큰 사이즈 쿠키를 가질 수 있는 아이를 구하면 더한다.
            /// 그 시점의 위치를 기억해놓고 다음에 사용한다.
            for (i in footprint + 1 until g.size) {
                footprint += 1
                if (cur >= g[i]) {
                    sum += 1
                    break
                }
            }
        }
        return sum
    }
}