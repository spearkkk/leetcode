class Solution {
    fun reverse(x: Int): Int {
        /// 엣지 케이스
        if (x == Int.MIN_VALUE) {
            return 0 
        }
        
        var num = if (x < 0) x * -1 else x

        var result = 0

        do {
            /// overflow 체크를 위해 계산한다.
            if (result * 10 / 10 != result) {
                return 0
            }
            result = result * 10 + num % 10
            num /= 10
        } while  (num > 0)

        return if (x < 0) -1 * result else result
    }
}
