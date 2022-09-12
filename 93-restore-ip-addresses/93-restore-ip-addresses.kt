class Solution {
    private fun restore(s: String, start: Int, current: String, currentPart: Int, result: MutableList<String>) {
        /// unreached part
        if (start > s.length) {
            return
        }

        /// check ip
        if (start == s.length) {
            if (currentPart > 4) {
                result.add(current.slice(1 until current.length))
            }
            return
        }

        if (currentPart > 4) {
            return
        }


        /// zero leading is accepted only '0'
        if (s[start] == '0') {
            return restore(s, start + 1, "$current.${s[start]}", currentPart + 1, result)
        }

        for (count in 1.. 3) {
            /// check index
            if (start + count > s.length) {
                continue
            }

            /// check count
            if ((4 - currentPart) * 3 < s.length - (start + count)) {
                continue
            }

            val addr = s.substring(start, start + count)
            if (addr.toInt() in 1..255) {

                restore(s, start + count, "$current.$addr", currentPart + 1, result)
            }
        }
    }

    fun restoreIpAddresses(s: String): List<String> {
        val result = mutableListOf<String>()
        restore(s, 0, "", 1, result)
        return result
    }
}