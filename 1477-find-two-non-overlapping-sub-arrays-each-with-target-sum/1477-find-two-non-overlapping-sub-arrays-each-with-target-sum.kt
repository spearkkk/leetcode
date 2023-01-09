class Solution {
  // one way, two pointers
  // https://youtu.be/Ek-r31znA0Q
    fun minSumOfLengths(arr: IntArray, target: Int): Int {
        val minLengths = IntArray(arr.size) { Int.MAX_VALUE }

        var currentSum = 0
        var leftCursor = 0

        var minLength = Int.MAX_VALUE

        var result = Int.MAX_VALUE

        for (rightCursor in arr.indices) {
            currentSum += arr[rightCursor]
            while (currentSum > target) {
                currentSum -= arr[leftCursor]
                leftCursor += 1
            }

            if (currentSum == target) {
                val length = rightCursor - leftCursor + 1

                if (leftCursor != 0 && minLengths[leftCursor - 1] != Int.MAX_VALUE) {
                    result = kotlin.math.min(result, minLengths[leftCursor - 1] + length)
                }
                minLength = kotlin.math.min(minLength, length)
            }
            minLengths[rightCursor] = minLength
        }

        return if (result != Int.MAX_VALUE) result else -1
    }
}