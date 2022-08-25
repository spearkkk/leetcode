class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        magazine.toCharArray()
        val charToCount: MutableMap<Char, Int> = magazine.toCharArray().toList().groupingBy { it }.eachCount().toMutableMap()
        for (c in ransomNote) {
            if (!charToCount.containsKey(c)) {
                return false
            }
            
            val nextCount = charToCount[c]!!.minus(1)
            if (nextCount == 0) {
                charToCount.remove(c)
            } else {
                charToCount[c] = nextCount
            }
        }

        return true
    }
}
