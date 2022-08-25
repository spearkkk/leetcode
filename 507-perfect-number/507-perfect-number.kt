class Solution {
    fun checkPerfectNumber(num: Int): Boolean {
        /// edge case
        if (num == 1) return false

        var sum = 1
        var cur = 2
        while (cur < num / 2) {
            if (num % cur == 0) {
                if (cur < num / cur) {
                    sum += num / cur
                } else {
                    break
                }
                /// 4 * 7에서 7은 이미 합을 함.
                /// 7 * 4에서 7을 더하지 않아야 하기 때문에 else 문 밑에다가 계산식을 넣는다
                sum += cur
            }
            cur += 1
        }

        return sum == num
    }
}