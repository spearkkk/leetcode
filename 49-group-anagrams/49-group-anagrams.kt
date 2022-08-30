class Solution {
    private fun isAnagram(s: String, t: String): Boolean {
        val footprint = hashMapOf<Char, Int>()

        for (c in s) {
            var count = footprint.getOrDefault(c, 0)
            count += 1
            footprint[c] = count
        }

        for (c in t) {
            var count = footprint.getOrDefault(c, 0)

            /// s에 존재하지 않는 문자가 있으면 anagram이 아니다.
            if (count == 0) {
                return false
            }
            count -= 1
            footprint[c] = count
        }

        if (footprint.values.find { it != 0 } != null) {
            return false
        }
        return true
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var cursor = 0
        val footprint = mutableMapOf<String, MutableList<String>>()

        while (cursor < strs.size) {
            val current = strs[cursor]
            var flag = true

            for (entry in footprint) {
                if (current.length == entry.key.length && isAnagram(current, entry.key)) {
                    entry.value.add(current)
                    flag = false
                    break
                }
            }

            if (flag) {
                footprint[current] = mutableListOf(current)
            }

            cursor += 1
        }

        return footprint.values.toList()
    }
}
