class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val marked = BooleanArray(1001) { false }

        for (num in nums1) {
            if (nums2.contains(num)) {
                marked[num] = true
            }
        }

        val holder = mutableListOf<Int>()
        for ((i, v) in marked.withIndex()) {
            if (v) {holder.add(i)}
        }

        return holder.toIntArray()
    }
}