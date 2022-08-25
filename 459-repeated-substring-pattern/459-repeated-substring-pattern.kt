class Solution {
    fun repeatedSubstringPattern(s: String): Boolean {
        var length = 1

        /// 반복을 하기 위해서는 sub string 길이의 두배보다 크거나 같아야 한다.
        while (s.length >= length * 2) {
            /// 0부터 length까지의 sub string을 만든다.
            val pattern = s.substring(0, length)

            /// sub string 뒤에서부터 검사를 해야 한다. 
            var start = length

            while (start + length <= s.length) {
                /// sub string이 맞지 않으면 길이를 증가 시켜서 다시 한다.
                if (pattern != s.substring(start, start + length)) {
                    length += 1
                    break
                }
                
                /// 다음 반복 문자열을 검사하기 위해 start를 갱신한다.
                start += length
            }

            /// 끝까지 검사하면 반환한다.
            if (start == s.length) {
                return true
            }
            
            if (start + length > s.length) {
                break
            }
        }
        return false
    }
}