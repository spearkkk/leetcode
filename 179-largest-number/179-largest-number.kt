class Solution {
    fun largestNumber(nums: IntArray): String {
        val comparator: Comparator<Int> = Comparator { o1, o2 ->
            val left = o1.toString()
            val right = o2.toString()

            val leftRight = left + right
            val rightLeft = right + left

            var cursor = 0

            var fromLeft = 0
            var fromRight = 0
            while (cursor < leftRight.length) {
                if (leftRight[cursor] != rightLeft[cursor]) {
                    fromLeft = leftRight[cursor].toInt() - '0'.toInt()
                    fromRight = rightLeft[cursor].toInt() - '0'.toInt()
                    break
                }
                cursor += 1
            }

            fromLeft - fromRight
        }

        val result = nums.sortedWith(comparator).reversed().joinToString("")
        return if (result.startsWith("0") && result.endsWith("0")) "0" else result
    }
}