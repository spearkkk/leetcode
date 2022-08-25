class Solution {
    fun isAnagram(s: String, t: String): Boolean {
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
}
