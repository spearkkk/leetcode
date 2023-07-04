class Solution {
    fun removeDuplicateLetters(s: String): String {
        val charToCount = HashMap<Char, Int>()

        for (letter in s) {
            charToCount[letter] = 1 + charToCount.getOrDefault(letter, 0)
        }

        val result = ArrayList<Char>()

        for (letter in s) {
            charToCount[letter] = charToCount[letter]!! - 1

            if (result.isEmpty()) {
                result.add(letter)
                continue
            }

            if (result.contains(letter)) {
                continue
            }
            
            while (result.isNotEmpty() && result.last() > letter && charToCount[result.last()]!! > 0) {
                result.removeAt(result.size - 1)
            }
            
            result.add(letter)
        }

        return result.joinToString("")
    }
}