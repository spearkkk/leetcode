class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (cursor in numbers.indices) {
            val nextTarget = target - numbers[cursor]
            
            for (secondCursor in cursor + 1 until numbers.size) {
                if (numbers[secondCursor] == nextTarget) {
                    return intArrayOf(cursor + 1, secondCursor + 1)
                }
                if (numbers[secondCursor] > nextTarget) {
                    break
                }
            }
        }
        return intArrayOf()
    }
}
