class Solution {
    fun numSplits(s: String): Int {
        val leftHolder = IntArray(26) { 0 }
        val rightHolder = IntArray(26) { 0 }

        for (i in s) {
            val index = i.toInt() - 97

            rightHolder[index] += 1
        }

        /// left <- right로 문자를 하나 옮겨가면서 distinct 한 문자들을 계산한다.
        /// distinct 문자의 수가 같다면 결과에 포함한다.
        var sum = 0
        for (i in s) {
            val index = i.toInt() - 97

            leftHolder[index] += 1
            rightHolder[index] -= 1

            sum += if (leftHolder.count { it == 0 } == rightHolder.count { it == 0}) 1 else 0
        }


        return sum
    }
}