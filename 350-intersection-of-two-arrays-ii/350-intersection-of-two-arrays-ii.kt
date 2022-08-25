class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val marked = IntArray(1001) { 0 }

        for (num in nums1) {
            val tmp = nums2.indexOf(num)
            if (tmp >= 0) {
                marked[num] += 1
                nums2[tmp] = -1
            }
        }

        val holder = mutableListOf<Int>()
        for ((i, v) in marked.withIndex()) {
            if (v > 0) {
                for (tmp in 1 .. v) {
                    holder.add(i)
                }
            }
        }

        return holder.toIntArray()
    }
}