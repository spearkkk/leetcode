class Solution {
    private fun isPalindrome(str: String): Boolean {
        for (i in 0 .. str.length / 2) {
            if (str[i] != str[str.length - 1 - i]) {
                return false
            }
        }

        return true
    }

    private fun doPartition(str: String, step: MutableList<String>, result: MutableList<List<String>>) {
        if (str.isBlank()) {
            result.add(step.toList())
            return
        }

        /// 1 부터 str 길이까지 sub string 을 만든다.
        for (maxLength in 1 .. str.length) {
            val subString = str.slice(0 until maxLength)

            /// 만든 sub string 이 palindrome 이면 나머지 문자열도 파티션을 한다.
            if (isPalindrome(subString)) {
                /// 여기서 넣은 sub string이 끝에 가서 result에 들어간다.
                step.add(subString)
                doPartition(str.slice(maxLength until str.length), step, result)
                
                /// 앞에 넣은 sub string을 제거해야 다른 길이의 sub string을 할 수 있다.
                step.removeAt(step.size - 1)
            }
        }
    }

    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        doPartition(s, mutableListOf(), result)
        return result.toList()
    }
}