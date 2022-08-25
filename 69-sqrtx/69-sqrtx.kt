class Solution {
    fun mySqrt(x: Int): Int {
        /// 엣지 케이스
        if (x < 2) {
            return x
        }

        var result = 1L

        /// 다음으로 넘어간 수의 제곱이 x 보다 클 때까지 반복한다.
        while ((result + 1) * (result + 1) <= x) {
            result += 1L
        }

        return result.toInt()
    }
}