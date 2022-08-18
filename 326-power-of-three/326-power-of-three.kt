class Solution {
    fun isPowerOfThree(n: Int): Boolean {
        /**
         * 1: 1
         * 3:  11
         * 9:  1001
         * 27: 11011
         * 81: 1010001
         * 243: 11110011
         */

        if (n <= 0) {
            return false
        }

        var currentValue = 1

        while (currentValue > 0) {
            if (n == currentValue) {
                return true
            }
            currentValue += currentValue.shl(1)
        }
        return false
    }
}
