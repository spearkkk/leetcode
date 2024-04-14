class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var cursor = 0
        for (i in 0 until nums.size - 1) {
            if (nums[i] > nums[i + 1]) {
                cursor = i + 1
                break
            }
        }

        for (i in cursor until nums.size + cursor) {
            val idx = i % nums.size
//            println("idx: $idx, nums[idx]: ${nums[idx]}")

            if (nums[idx] == target) {
                return idx
            }

            if (nums[idx] > target) {
                return -1
            }
        }
        return -1
    }
}