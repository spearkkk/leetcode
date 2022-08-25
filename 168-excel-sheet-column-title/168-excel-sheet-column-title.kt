class Solution {
    private fun convert(n: Int): String {
        val holder = arrayOf("NONE",
            "A", "B", "C", "D",
            "E", "F", "G", "H",
            "I", "J", "K", "L",
            "M", "N", "O", "P",
            "Q", "R", "S", "T",
            "U", "V", "W", "X",
            "Y", "Z")

        /// 701 = 26 * 26  + 25
        /// 52 = 26 * 1 + 26
        if (n <= 26) {
            return holder[n]
        }

        val something = n / 26
        val nothing = n % 26

        if (nothing == 0) {
            return convert(something - 1) + holder[26]
        }

        return convert(something) + holder[nothing]
    }

    fun convertToTitle(n: Int): String {
        return convert(n)
    }
}
