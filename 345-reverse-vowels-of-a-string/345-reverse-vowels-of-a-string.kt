class Solution {
    private fun isVowel(c: Char): Boolean {
        return charArrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c)
    }

    fun reverseVowels(s: String): String {
        val str = s.toCharArray()
        var left = 0
        var right = s.length - 1

        while (true) {
            while (!isVowel(str[left]) && left < str.size - 1) {
                left += 1
            }
            while (!isVowel(str[right]) && right > 0) {
                right -= 1
            }
            if (left >= right) {
                break
            }

            val tmp = str[left]
            str[left] = str[right]
            str[right] = tmp
            left += 1
            right -= 1
        }

        return String(str)
    }
}
