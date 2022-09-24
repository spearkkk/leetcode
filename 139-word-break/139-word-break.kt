class Solution {
    private val footprint = mutableSetOf<Pair<Int, String>>()
    private fun doBreak(s: String, wordDict: List<String>, start: Int): Boolean {
        if (s.isBlank()) {
            return true
        }

        if (footprint.contains(Pair(start, s))) {
            return false
        }

        if (start >= wordDict.size) {
            return false
        }

        if ((s.startsWith(wordDict[start]) && doBreak(s.substring(wordDict[start].length), wordDict, 0))) {
            return true
        }

        footprint.add(Pair(start, s))

        return doBreak(s, wordDict, start + 1)
    }

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return doBreak(s, wordDict, 0)
    }
}