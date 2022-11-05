class Solution {
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {

        val priorityQueue = java.util.PriorityQueue<Pair<Pair<Int, Int>, Int>> { o1, o2 -> o1.first.first + o1.first.second - (o2.first.first + o2.first.second) }

        if (nums1.isEmpty() || nums2.isEmpty()) {
            return emptyList()
        }

        for (cursor in 0 until kotlin.math.min(k, nums1.size)) {
            priorityQueue.offer(Pair(Pair(nums1[cursor], nums2[0]), 0))
        }

        val result = mutableListOf<List<Int>>()
        while (priorityQueue.isNotEmpty() && result.size < k) {
            val current = priorityQueue.poll()
            result.add(listOf(current.first.first, current.first.second))
            if (current.second == nums2.size - 1) {
                continue
            }
            priorityQueue.offer(Pair(Pair(current.first.first, nums2[current.second + 1]), current.second + 1))
        }
        return result
    }
}