class Solution {
    fun countVowelStrings(n: Int): Int {
        val vowel = intArrayOf(1, 1, 1, 1, 1)

        /// n 이 1일 경우, 5가지 경우이기 때문에 계산할 필요가 없다.
        for (i in 2 .. n) {
            val availableVowelCount = IntArray(5)

            /// a는 a,e,i,o,u 를 다 가질 수 있지만,
            /// u는 u만 가질 수 있다.
            for (j in 0 until 5) {
                availableVowelCount[j] = vowel.slice(0 .. j).sum()
            }

            for (j in 0 until 5) {
                vowel[j] = availableVowelCount[j]
            }
        }

        return vowel.sum()
    }
}