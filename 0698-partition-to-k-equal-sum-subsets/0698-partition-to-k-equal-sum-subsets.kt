class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        if (nums.size < k) {
            return false
        }

        val sum = nums.sum()
        if (sum % k != 0) {
            return false
        }

        val targetSum = sum / k

        val sortedNum = nums.sortedDescending()
        val visited = BooleanArray(nums.size) { false }

        fun dfs(cursor: Int, currentSum: Int, loopCnt: Int): Boolean {
            if (loopCnt == 0) {
                return true
            }

            if (targetSum == currentSum && dfs(0, 0, loopCnt - 1)) {
                return true
            }

            for (innerCursor in cursor until nums.size) {
                if (!visited[innerCursor] && currentSum + sortedNum[innerCursor] <= targetSum) {
                    visited[innerCursor] = true
                    if (dfs(innerCursor + 1, currentSum + sortedNum[innerCursor], loopCnt)) {
                        return true
                    }
                    visited[innerCursor] = false
                }
            }
            return false
        }
        return dfs(0, 0, k)
    }
}