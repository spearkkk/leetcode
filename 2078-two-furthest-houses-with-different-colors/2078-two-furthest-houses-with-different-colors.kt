class Solution {
    fun maxDistance(colors: IntArray): Int {
        if (colors.size < 2) {
            return 0
        }

        val footprint = mutableMapOf<Pair<Int, Int>, Int>()
        
        fun check(left: Int, right: Int): Int {
            if (left > right) {
                return 0
            }
            
            val key = Pair(left, right)
            if (footprint[key] != null) {
                return footprint[key]!!
            }

            if (colors[left] != colors[right]) {
                return right - left
            }

            val value = kotlin.math.max(check(left + 1, right), check(left, right - 1))
            footprint[key] = value
            return value
        }

        return check(0, colors.size - 1)
    }
}