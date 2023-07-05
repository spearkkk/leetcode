class Solution {
    fun maximum69Number (num: Int): Int {
        var max = num
        var base = 1
        
        while (base < max) {
            val tmp = num - ((num / base) % 10) * base + 9 * base
            if (tmp > max) {
                max = tmp
            }
            base *= 10
        }
        return max
    }
}