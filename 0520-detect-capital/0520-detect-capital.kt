class Solution {
    fun detectCapitalUse(word: String): Boolean {
        fun isAllUpperCase(): Boolean {
            for (cursor in 1 until word.length) {
                if (word[cursor].isLowerCase()) {
                    return false
                }
            }
            return true
        }

        fun isAllLowerCase(): Boolean {
            for (cursor in 1 until word.length) {
                if (word[cursor].isUpperCase()) {
                    return false
                }
            }
            return true
        }

        return if (word[0].isUpperCase()) {
            isAllUpperCase() || isAllLowerCase()
        } else {
            isAllLowerCase()
        }
    }
}