class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {

        val answer = ArrayList<String>()
        val answers = ArrayList<String>()

        fun bt(current: String) {
            if (current.isEmpty()) {
                answers.add(answer.joinToString(" "))
                return
            }

            for (i in wordDict.indices) {
                if (!current.startsWith(wordDict[i])) {
                    continue
                }

                answer.add(wordDict[i])
                bt(current.substring(wordDict[i].length))
                
                answer.removeLast()
            }
        }

        bt(s)

        return answers
    }
}