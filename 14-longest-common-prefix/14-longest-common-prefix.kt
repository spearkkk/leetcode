class Solution {
    private fun getCommonPrefix(prefix: String, str: String): String {
        /// 지금의 접두사가 제일 긴 접두사이기 때문에 str가 이 접두사로 시작하기만 하면 만족한다.
        if (str.startsWith(prefix)) {
            return prefix
        }
        /// str가 접두사보다 작은 문자여일 경우
        if (str.length < prefix.length && prefix.startsWith(str)) {
            return str
        }
        
        var newPrefix = prefix
        while (newPrefix.isNotBlank()) {
            if (str.startsWith(newPrefix)) {
                return newPrefix
            }
            newPrefix = newPrefix.substring(0, newPrefix.length - 1)
        }
        
        return ""
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        /// edge case
        if (strs.isEmpty()) {
            return ""
        }

        var result: String = strs[0]

        for (str in strs) {
            /// 루프를 돌면서 result 가 blank인 순간이 공통의 접두사가 없다는 것을 의미한다.
            if (result.isBlank()) {
                return ""
            }

            result = getCommonPrefix(result, str)
        }
        
        return result
    }
}