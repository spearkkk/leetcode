class Solution {
    // idx1: 제일 큰 수의 위치
    // idx2: 두 번째로 큰 수의 위치
    // 큰 수와 두 번째로 큰 수의 위치와 현재 위치가 인접하지 않았으면, 훔친다.
    private fun doRobbing(nums: IntArray): Int {
        if (nums.size <= 2) {
            return nums[if (nums[0] < nums.getOrElse(1) { 0 }) 1 else 0]

        }

        var idx1 = if (nums[0] < nums[1]) 1 else 0
        var idx2 = if (nums[0] >= nums[1]) 1 else 0

        for (i in 2 until nums.size) {
            if (i - idx1 > 1) {
                nums[i] = nums[idx1] + nums[i]
                idx2 = idx1
                idx1 = i
                continue
            }

            if (i - idx2 > 1) {
                nums[i] = nums[idx2] + nums[i]
                if (nums[i] <= nums[idx1]) {
                    idx2 = i
                } else {
                    idx2 = idx1
                    idx1 = i
                }
                continue
            }
        }

        return if (nums[idx1] > nums[idx2]) nums[idx1] else nums[idx2]
    }

    // 첫 번째 집을 터는 순간과 첫 번째 집을 털지 않는 순간의 결과를 비교한다.
    fun rob(nums: IntArray): Int {

        // 엣지 케이스
        if (nums.size <= 2) {
            return nums[if (nums[0] < nums.getOrElse(1) { 0 }) 1 else 0]
        }

        // 엣지 케이스
        if (nums.size == 3) {
            return kotlin.math.max(kotlin.math.max(nums[0], nums[1]), nums[2])
        }

        val robbed = nums[0]
        val totalRobbed = robbed + doRobbing(nums.slice(2 until nums.size - 1).toIntArray())

        val totalRobbedWithoutFirstHouse = doRobbing(nums.slice(1 until nums.size).toIntArray())

        return kotlin.math.max(totalRobbed, totalRobbedWithoutFirstHouse)
    }
}
