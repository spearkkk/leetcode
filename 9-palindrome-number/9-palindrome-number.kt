class Solution {    
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