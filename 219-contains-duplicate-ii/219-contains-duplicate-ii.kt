class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (k == 0) {
            return false
        }

        val holder = hashSetOf<Int>()

        /// 0부터 k까지의 값을 미리 넣어둔다.
        for (cursor in 0 .. k) {
            if (cursor < nums.size) {
                if (holder.contains(nums[cursor])) {
                    return true
                }
                holder.add(nums[cursor])
            }
        }

        /// k의 다음부터 중복을 검사한다.
        /// 중복이 없으면 그 값을 다시 넣어준다.
        for (i in 0 until nums.size - k - 1) {
            holder.remove(nums[i])
            if (holder.contains(nums[i + k + 1])) {
                return true
            }
            holder.add(nums[i + k + 1])
        }
        return false
    }
}
