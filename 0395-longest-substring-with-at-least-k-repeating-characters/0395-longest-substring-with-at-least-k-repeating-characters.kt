class Solution {
    fun longestSubstring(s: String, k: Int): Int {

        if (s.isBlank()) return 0

        var cursor = 1
        var count = 1
        var last = s[0]
        val holder = mutableListOf<Pair<Char, Int>>()

        // 일단 문자열을 각각의 문자열, 개수로 압축한다. 순서를 반드시 지켜야한다.
        while (cursor < s.length) {
            if (last == s[cursor]) {
                count += 1
            } else {
                holder.add(Pair(last, count))
                count = 1
                last = s[cursor]
            }
            cursor += 1
        }
        holder.add(Pair(last, count))

        var max = 0
        // 압축한 문자, 개수의 데이터를 대상으로 부분 문자열을 만들 때, 주어진 k개 이상을 만족하는지 확인한다.
        // k개 이상을 만족하는 부분 문자열의 최대 길이를 계산한다.
        for (len in (1 .. holder.size).reversed()) {
            for (anotherCursor in 0 .. holder.size - len) {
                val tmp = mutableMapOf<Char, Int>()

                holder.slice(anotherCursor until anotherCursor + len).forEach {
                    val char = it.first
                    val count = it.second
                    tmp[char] = (tmp[char] ?: 0) + count
                }

                if (tmp.values.all { it >= k } && tmp.values.sum() > max) {
                    max = tmp.values.sum()
                }
            }
        }

        return max
    }
}