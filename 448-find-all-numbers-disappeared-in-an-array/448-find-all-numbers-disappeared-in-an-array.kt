class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val holder = mutableListOf<Int>()

        for (i in 1 .. nums.size) {
            /// nums에 없다는 것는 비어 있는 값이다.
            if (!nums.contains(i)) {
                holder.add(i)
            }
        }
        return holder
    }
}