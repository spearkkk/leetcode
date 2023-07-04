class Solution {
    fun removeDuplicateLetters(s: String): String {
        // 문자를 카운트한다.
        val charToCount = HashMap<Char, Int>()

        for (letter in s) {
            charToCount[letter] = 1 + charToCount.getOrDefault(letter, 0)
        }

        val result = ArrayList<Char>()

        for (letter in s) {
            // 처리할 문자에 대한 카운트를 감소시킨다.
            charToCount[letter] = charToCount[letter]!! - 1

            if (result.isEmpty()) {
                result.add(letter)
                continue
            }

            // result 값은 최적의 상태이기 때문에 중복으로 추가할 필요가 없다.
            if (result.contains(letter)) {
                continue
            }

            // 새로운 문자를 추가하기 전, 순서를 고려하며 문자열을 추가한다. 
            while (result.isNotEmpty() && result.last() > letter && charToCount[result.last()]!! > 0) {
                result.removeAt(result.size - 1)
            }

            result.add(letter)
        }

        return result.joinToString("")
    }
}