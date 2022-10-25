class Solution {
    fun maxProduct(words: Array<String>): Int {
        fun check(left: String, right: String): Boolean {
            for (l in left) {
                for (r in right) {
                    if (l == r) {
                        return false
                    }
                }
            }
            return true
        }
        
        var max = 0

        for (leftCursor in words.indices) {
            val left = words[leftCursor]
            
            for (rightCursor in leftCursor + 1 until words.size) {
                val right = words[rightCursor]
                
                if (left.length * right.length > max && check(left, right)) {
                    max = left.length * right.length
                }
            }

        }
        
        return max
    }
}