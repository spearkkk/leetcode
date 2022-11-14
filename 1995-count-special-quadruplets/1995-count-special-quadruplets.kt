class Solution {
    fun countQuadruplets(nums: IntArray): Int {
        if (nums.size < 4) {
            return 0
        }
        
        var cnt = 0
        for (cursor1 in 0 until nums.size - 3) {
            for (cursor2 in cursor1 + 1 until nums.size - 2) {
                for (cursor3 in cursor2 + 1 until nums.size - 1) {
                    for (cursor4 in cursor3 + 1 until nums.size) {
                        if (nums[cursor1] + nums[cursor2] + nums[cursor3] == nums[cursor4]) {
                            cnt += 1
                        }
                    }
                }
            }
        }
        return cnt
    }
}