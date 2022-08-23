class Solution {
    private fun searchFirst(nums: IntArray, target: Int, start: Int, end: Int, defaultValue: Int): Int {
        if (start > end) {
            return defaultValue
        }

        val middle = (end - start) / 2 + start

        /// 앞으로 가야한다.
        if (nums[middle] == target) {
            return searchFirst(nums, target, start, middle - 1, middle)
        }

        if (nums[middle] < target) {
            return searchFirst(nums, target, middle + 1, end, defaultValue)
        }
        return searchFirst(nums, target, start, middle - 1, defaultValue)
    }

    private fun searchLast(nums: IntArray, target: Int, start: Int, end: Int, defaultValue: Int): Int {
        if (start > end) {
            return defaultValue
        }

        val middle = (end - start) / 2 + start

        /// 뒤로 가야한다.
        if (nums[middle] == target) {
            return searchLast(nums, target, middle + 1, end, middle)
        }

        if (nums[middle] < target) {
            return searchLast(nums, target, middle + 1, end, defaultValue)
        }
        return searchLast(nums, target, start, middle - 1, defaultValue)
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        /// first를 먼저 찾는다.
        val first = searchFirst(nums, target, 0, nums.size - 1, -1)
        /// first를 찾은 이후부터 last를 찾는다.
        val last = searchLast(nums, target, first + 1, nums.size - 1, -1)
        
        /// 엣지 케이스로 first는 찾았지만 last는 못찾은 경우, 즉 원소가 한개일 경우
        if (last == -1 && first != last) {
            return intArrayOf(first, first)
        }
        
        return intArrayOf(first, last)
    }
}
