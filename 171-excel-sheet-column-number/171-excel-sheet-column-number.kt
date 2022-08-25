class Solution {
    fun titleToNumber(columnTitle: String): Int {
        var result = 0
        for (cursor in columnTitle.indices) {
            var base = 1
            for (j in 1 .. cursor) {
                base *= 26
            }
            // result += base * (columnTitle[columnTitle.length - cursor - 1].code - 64)
            result += base * (columnTitle[columnTitle.length - cursor - 1].toInt() - 64)
        }

        return result
    }
}
