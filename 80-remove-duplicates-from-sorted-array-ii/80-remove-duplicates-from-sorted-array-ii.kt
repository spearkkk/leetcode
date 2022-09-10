class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var stored = nums[0]
        var count = 1

        var position = 1
        var cursor = 1
        while (cursor < nums.size) {
            if (nums[cursor] == stored && count >= 2) {
                cursor += 1
                continue
            }

            if (nums[cursor] == stored) {
                count += 1
            } else {
                count = 1
            }

            nums[position] = nums[cursor]
            stored = nums[cursor]

            position += 1
            cursor += 1
        }

        return position
    }
}