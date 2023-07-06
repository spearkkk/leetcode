class Solution {
    fun isMatch(s: String, p: String): Boolean {
        var sIndex = 0
        var pIndex = 0
        val sLen = s.length
        val pLen = p.length

        var starPosition = -1
        var match = -1

        while (sIndex < sLen) {
            if (pIndex < pLen && (s[sIndex] == p[pIndex] || p[pIndex] == '?')) {
                sIndex += 1
                pIndex += 1
            } else if (pIndex < pLen && p[pIndex] == '*') {
                // '*'에 대한 인덱스를 저장하고 다음 인덱스로 옮긴다.
                starPosition = pIndex
                pIndex += 1

                // '*'을 찾은 시점에 문자열 인덱스를 저장한다. '*' 공백문자열도 허용한다.
                match = sIndex
                continue
            } else if (starPosition != -1) {
                // 여기까지 왔다는 것은 문자열과 패턴이 일치하지 않았고, 패턴이 '*' 아닐 경우이다.
                // 이 때, 이미 '*'패턴이 있다면 문자열을 무한히 매칭시킬 수 있다.

                // 다시 패턴의 인덱스를 초기화('*' 다음 인덱스) 해준다. 왜냐하면 '*' 뒤에 오는 패턴이 문자열에 있는지 확인이 필요하기 때문이다.
                pIndex = starPosition + 1

                match += 1
                sIndex = match
                continue
            } else {
                return false
            }
        }

        // 패턴이 끝까지 도착할 수 있는지 확인한다.
        while (pIndex < pLen && p[pIndex] == '*') {
            pIndex += 1
        }
        return pIndex == pLen
    }
}