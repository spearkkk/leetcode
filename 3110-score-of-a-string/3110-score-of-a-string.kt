class Solution {
    fun scoreOfString(s: String): Int {
        var answer = 0
        
        var cursor = 1
        while (cursor < s.length) {
            val left = s[cursor - 1]
            val right = s[cursor]
            answer += kotlin.math.abs(left.code - right.code)
            
            cursor += 1
        }
        
        return answer
    }
}