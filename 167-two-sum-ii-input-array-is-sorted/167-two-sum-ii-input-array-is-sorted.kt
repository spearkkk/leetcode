class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (cursor in numbers.indices) {
            for (secondCursor in cursor + 1 until numbers.size) {
                if (numbers[cursor] + numbers[secondCursor] == target) {
                    return intArrayOf(cursor + 1, secondCursor + 1)
                }
            }
        }
        return intArrayOf()
    }
}