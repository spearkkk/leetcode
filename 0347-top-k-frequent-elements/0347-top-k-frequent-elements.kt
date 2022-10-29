class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        nums.sort()

        val counts = mutableListOf<Pair<Int, Int>>()

        var cursor = 1
        var current = nums[0]
        var count = 1
        while (cursor < nums.size) {
            if (nums[cursor] == current) {
                count += 1
                cursor += 1
                continue
            }

            counts.add(Pair(count, current))

            count = 1
            current = nums[cursor]
            cursor += 1
        }
        counts.add(Pair(count, current))

        return counts.sortedByDescending { it.first }.slice(0 until k).map { it.second }.toIntArray()
    }
}