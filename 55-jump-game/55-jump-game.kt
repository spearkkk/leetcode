class Solution {
    private fun isDone(cur: Int, nums: IntArray): Boolean {
        return cur + nums[cur] >= nums.size - 1
    }

    private fun trying(cur: Int, nums: IntArray, marked: IntArray): Boolean {
        /// 이미 와본 곳인데 또 들어왔다면 끝을 도달할 수 없다.
        if (marked[cur] == 1) {
            return false
        }

        /// 끝까지 갈 수 있으면 반환한다.
        if (isDone(cur, nums)) {
            return true
        }

        /// 이미 와본 곳을 체크한다.
        marked[cur] = 1

        /// 점프할 수 있는 거리만큼 다 점프해본다.
        for (i in 0 until nums[cur]) {
            if (trying(cur + i + 1, nums, marked)) {
                return true
            }
        }
        return false
    }

    fun canJump(nums: IntArray): Boolean {
        val marked = IntArray(nums.size) { 0 }

        return trying(0, nums, marked)
    }
}
