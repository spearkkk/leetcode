class Solution {
    private val decodes = (1 .. 26).map { it.toString() }.toSet()
    private val memoization = hashMapOf<String, Int>()

    private fun canBeDecoded(s: String): Boolean {
        return decodes.contains(s)
    }

    private fun decode(s: String): Int {
        if (memoization.contains(s)) {
            return memoization.getOrDefault(s, 0)
        }

        if (s.isBlank()) {
            return 1
        }

        if (s.length == 1) {
            if (canBeDecoded(s)) {
                return 1
            }
            return 0
        }

        var count = 0
        /// 첫 글자만 때서 디코딩한다.
        if (canBeDecoded(s.slice(0 until 1))) {
            count += decode(s.slice(1 until s.length))
        }
        /// 두 글자만 때서 디코딩한다.
        if (canBeDecoded(s.slice(0 until 2))) {
            count += decode(s.slice(2 until s.length))
        }
        memoization[s] = count
        return count
    }

    fun numDecodings(s: String): Int {
        return decode(s)
    }
}
