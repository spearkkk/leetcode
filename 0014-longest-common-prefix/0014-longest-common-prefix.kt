class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {

        data class TrieNode(var word: String? = null, val children: MutableMap<Char, TrieNode> = mutableMapOf())
        val root = TrieNode()
        for (word in strs) {
            var cursor = root

            for (c in word.toCharArray()) {
                if (!cursor.children.contains(c)) {
                    cursor.children[c] = TrieNode()
                }
                cursor = cursor.children[c]!!
            }

            cursor.word = word
        }

        val sb = StringBuilder()
        var cursor = root
        while (cursor.children.size == 1 && cursor.word == null) {
            val c = cursor.children.keys.first()
            sb.append(c)
            cursor = cursor.children[c]!!
        }

        return sb.toString()
    }
}