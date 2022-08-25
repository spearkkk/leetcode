class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val charToCount = IntArray(26) { 0 }
        for (c in magazine) {
            val index = c.toInt() - 'a'.toInt()
            charToCount[index] += 1
        }
        for (c in ransomNote) {
            val index = c.toInt() - 'a'.toInt()
            charToCount[index] -= 1
            if (charToCount[index] == -1) {
                return false
            }
        }
        return true
    }
}
