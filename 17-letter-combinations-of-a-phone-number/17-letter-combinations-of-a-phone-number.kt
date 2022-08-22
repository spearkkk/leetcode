class Solution {
    private val digitToCharacters = mapOf(
        Pair(2, charArrayOf('a', 'b', 'c')),
        Pair(3, charArrayOf('d', 'e', 'f')),
        Pair(4, charArrayOf('g', 'h', 'i')),
        Pair(5, charArrayOf('j', 'k', 'l')),
        Pair(6, charArrayOf('m', 'n', 'o')),
        Pair(7, charArrayOf('p', 'q', 'r', 's')),
        Pair(8, charArrayOf('t', 'u', 'v')),
        Pair(9, charArrayOf('w', 'x', 'y', 'z'))
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isBlank()) {
            return emptyList()
        }

        var result = arrayListOf(listOf(""))

        for (cursor in digits.indices) {
            val digit = digits[cursor].toInt() - '0'.toInt()

            val tmp = arrayListOf<List<String>>()
            
            /// 현재 결과에 있는 문자열들을 꺼내다가 문자를 붙인다.
            /// 처리한 결과를 result에 넣으면 계속 반복하기 때문에 임시 리스트를 사용한다.
            for (list in result) {
                for (char in digitToCharacters[digit]!!) {
                    tmp.add(list.map { "$it$char" })
                }
            }
            result = tmp
        }

        return result.flatten().toList()
    }
}
