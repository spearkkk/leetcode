class Solution {
    private fun check(row: Set<Char>, word: String): Boolean {
        return word.map { c -> row.contains(c)}.reduce { a, b -> a && b }
    }

    fun findWords(words: Array<String>): Array<String> {
        val firstRow = setOf('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P')
        val secondRow = setOf('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L')
        val thirdRow = setOf('z', 'x', 'c', 'v', 'b', 'n', 'm', 'Z', 'X', 'C', 'V', 'B', 'N', 'M')

        val result = arrayListOf<String>()

        for (word in words) {
            if (check(firstRow, word) || check(secondRow, word) || check(thirdRow, word)) {
                result.add(word)
            }
        }
        return result.toArray(arrayOfNulls(result.size))
    }
}