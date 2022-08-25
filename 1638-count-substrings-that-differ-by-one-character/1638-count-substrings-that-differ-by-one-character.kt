class Solution {
    private fun couldBe(s: String, t: String): Boolean {
        if (s.length == 1 && s != t) {
            return true
        }

        var cnt = 0

        for (i in s.indices) {
            if (cnt > 1) {
                return false
            }

            if (s[i] != t[i]) {
                cnt += 1
            }
        }

        return cnt == 1
    }

    private fun getAllSubStrings(str: String): Map<Int, List<String>> {
        val holder = mutableMapOf<Int, List<String>>()

        for (i in 1 .. str.length) {
            val subStrings: ArrayList<String> = arrayListOf()

            for (j in 0 .. str.length - i) {
                val candi = str.slice(j until j + i)

                subStrings.add(candi)
            }

            holder.put(i, subStrings)
        }

        return holder
    }

    fun countSubstrings(s: String, t: String): Int {

        val sLevelToSubStrings = getAllSubStrings(s)
        val tLevelToSubStrings = getAllSubStrings(t)

        var sum = 0
        for (level in sLevelToSubStrings.keys) {
            val sSubStrings = sLevelToSubStrings.getOrDefault(level, listOf())
            val tSubStrings = tLevelToSubStrings.getOrDefault(level, listOf())

            for (tmpS in sSubStrings) {
                for (tmpT in tSubStrings) {
                    if (couldBe(tmpS, tmpT)) {
                        sum += 1
                    }
                }
            }

        }

        return sum
    }
}