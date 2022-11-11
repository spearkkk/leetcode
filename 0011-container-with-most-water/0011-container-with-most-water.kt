class Solution {
    fun maxArea(height: IntArray): Int {
        if (height.size < 2) return 0
        var max = 0

        var left = 0
        var right = height.size - 1

        while (left < right) {
            val current = (right - left) * kotlin.math.min(height[left], height[right])
            if (max < current) {
                max = current
            }

            if (height[left] < height[right]) {
                left += 1
            } else {
                right -=1
            }
        }

        return max
    }
}