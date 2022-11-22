class Solution {
    fun stringMatching(words: Array<String>): List<String> {
        val result =  mutableSetOf<String>()

        var cursor = 0
        while (cursor < words.size) {
            var anotherCursor = cursor + 1
            while (anotherCursor < words.size) {
                if (words[anotherCursor].indexOf(words[cursor]) >= 0) {
                    result.add(words[cursor])
                }
                if (words[cursor].indexOf(words[anotherCursor]) >= 0) {
                    result.add(words[anotherCursor])
                }
                anotherCursor += 1
            }
            cursor += 1
        }

        return result.toList()
    }
}