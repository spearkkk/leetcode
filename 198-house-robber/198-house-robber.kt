class Solution {
    // firstMaximumIndex: 제일 큰 수의 위치
    // secondMaximumIndex: 두 번째로 큰 수의 위치
    // 큰 수와 두 번째로 큰 수의 위치와 현재 위치가 인접하지 않았으면, 훔친다.
    fun rob(nums: IntArray): Int {
        /// 엣지 케이스
        if (nums.size <= 2) {
            return nums[if (nums[0] < nums.getOrElse(1) { 0 }) 1 else 0]

        }

        var firstMaximumIndex = if (nums[0] < nums[1]) 1 else 0
        var secondMaximumIndex = if (nums[0] >= nums[1]) 1 else 0

        for (cursor in 2 until nums.size) {
            if (cursor - firstMaximumIndex > 1) {
                nums[cursor] = nums[firstMaximumIndex] + nums[cursor]
                secondMaximumIndex = firstMaximumIndex
                firstMaximumIndex = cursor
                continue
            }

            if (cursor - secondMaximumIndex > 1) {
                nums[cursor] = nums[secondMaximumIndex] + nums[cursor]
                if (nums[cursor] <= nums[firstMaximumIndex]) {
                    secondMaximumIndex = cursor
                } else {
                    secondMaximumIndex = firstMaximumIndex
                    firstMaximumIndex = cursor
                }
                continue
            }
        }

        return if (nums[firstMaximumIndex] > nums[secondMaximumIndex]) nums[firstMaximumIndex] else nums[secondMaximumIndex]
    }
}
