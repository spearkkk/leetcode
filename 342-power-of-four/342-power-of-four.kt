class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        /**
         * 1
         * 100
         * 10000
         * 1000000
         */
        
        if (n <= 0) {
            return false
        }
        
        var currentValue = 1
        
        while (currentValue > 0) {
            if (currentValue == n) {
                return true
            }
            
            currentValue = currentValue.shl(2)
        }
        return false
    }
}