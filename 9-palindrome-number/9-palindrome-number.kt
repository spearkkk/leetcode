class Solution {
    /**
     * ### Solution
     * 1. edge case 제거: `x < 0`
     * 2. 숫자를 1의 자리부터 다시 계산
     * 예를 들어, ‘123’의 숫자가 있으면 loop을 통해
     * 1. 3
     * 2. 32
     * 3. 321
     * 4. 더 이상 진행할 숫자가 없으면 123과 321을 비교.
     */
    
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }

        var n = x
        val ten = 10
        
        var candidate = 0
        while (true) {
            val remainder: Int = n % ten
            candidate = (candidate * ten) + remainder

            if (n / ten == 0) {
                return x == candidate
            }
            n /= ten
        }
    }
}