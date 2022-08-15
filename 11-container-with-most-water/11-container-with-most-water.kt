class Solution {
    fun maxArea(height: IntArray): Int {
        /// 양쪽 끝에서 부턴 넓이를 계산한다.
        var start = 0
        var end = height.size - 1

        var result = 0

        while (start < end) {
            /// 넓이를 계산할 때, 높이 중 최솟값을 사용해야 한다.
            val minHeight = if (height[start] < height[end]) height[start] else height[end]
            val area = minHeight * (end - start)
            if (result < area) {
                result = area
            }

            /// 중간에 높이가 더 큰 지점이 있을 수 있기 때문에 안쪽으로 범위를 좁혀가야 한다.
            if (height[start] < height[end]) start += 1 else end -= 1
        }

        return result
    }
}