class Solution {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        if (n == 0) return 1
        
        var uniqueCnt = 9
        var available = 9
        
        var count = 10
        
        var cursor = 1
        while (cursor < n && available > 0) {
            uniqueCnt *= available
            
           count += uniqueCnt
           available -= 1 
            
            cursor += 1
        }

        return count
    }
}