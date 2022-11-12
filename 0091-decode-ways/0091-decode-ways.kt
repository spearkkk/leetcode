class Solution {
    fun numDecodings(s: String): Int {
        val keyToValue = (1 .. 26).map { it.toString() to 'A' + it - 1 }.toMap()
        val memoization = mutableMapOf<String, Int>()

        fun decode(s: String): Int {
            if (memoization[s] != null) {
                return memoization[s]!!
            }

            if (s.isBlank()) {
                return 1
            }

            var count = 0
            if (keyToValue.containsKey(s.slice(0 until 1))) {
                count += decode(s.slice(1 until s.length))
            }
            if (s.length >= 2 && keyToValue.containsKey(s.slice(0 .. 1))) {
                count += decode(s.slice(2 until s.length))
            }
            memoization[s] = count
            return count
        }

        return decode(s)
    }
}