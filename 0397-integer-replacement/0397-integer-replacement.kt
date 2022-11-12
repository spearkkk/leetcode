class Solution {
    fun integerReplacement(n: Int): Int {
        val holder = mutableMapOf(Pair(1, 0), Pair(Int.MAX_VALUE, 32))

        var two = 1
        for (cursor in 1 .. 30) {
            two *= 2
            holder[two] = cursor
        }

        fun count(current: Int, footprint: MutableList<Int>): Int {
            if (current == 1) {
                return 0
            }

            if (holder.contains(current)) {
                return holder[current]!!
            }

            if (footprint.contains(current)) {
                return Int.MAX_VALUE
            }

            footprint.add(current)
            val tmp = if (current % 2 == 0) {
                count(current / 2, footprint) + 1
            } else {
                val tmp1 = count(current + 1, footprint) + 1
                val tmp2 = count(current - 1, footprint) + 1

                kotlin.math.min(tmp1, tmp2)
            }

            footprint.removeAt(footprint.size - 1)
            holder[current] = tmp
            return tmp
        }

        return count(n, mutableListOf())
    }
}