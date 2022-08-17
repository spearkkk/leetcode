class Solution {
    fun isPalindrome(s: String): Boolean {
        val str = s.replace(Regex("[^a-zA-Z0-9]"), "").toLowerCase()
        if (str.isBlank()) {
            return true
        }

        for (i in 0 .. str.length / 2) {
            if (str[i] != str[str.length - 1 - i]) {
                return false
            }
        }

        return true
    }
}