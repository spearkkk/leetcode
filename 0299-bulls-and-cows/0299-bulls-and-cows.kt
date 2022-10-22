class Solution {
    fun getHint(secret: String, guess: String): String {
        if (secret.length != guess.length) {
            return ""
        }

        var a = 0
        var b = 0

        val charToCount = mutableMapOf<Char, Int>()
        val guessChars = mutableListOf<Char>()
        for (cursor in guess.indices) {
            if (secret[cursor] == guess[cursor]) {
                a += 1
                continue
            }
            charToCount[secret[cursor]] = (charToCount[secret[cursor]] ?: 0) + 1
            guessChars.add(guess[cursor])
        }

        for (char in guessChars) {
            if (charToCount.containsKey(char) && charToCount[char]!! > 0) {
                b += 1

                charToCount[char] = charToCount[char]!! - 1
            }
        }

        return "${a}A${b}B"
    }
}