class Solution {
    fun majorityElement(nums: IntArray): Int {
        val holder = HashMap<Int, Int>()

        for (n in nums) {
            holder[n] = holder.getOrDefault(n, 0) + 1
        }

        return holder.maxBy { entry: Map.Entry<Int, Int> -> entry.value }!!.key
    }
}
