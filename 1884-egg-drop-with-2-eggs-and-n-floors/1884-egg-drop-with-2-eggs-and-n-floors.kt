class Solution {
    private val holder = IntArray(1001) { 0 }

    fun twoEggDrop(n: Int): Int {

        if (holder[n] == 0) {
            for (i in 1 .. n) {
                val left = if (holder[n] == 0) n else holder[n]
                val right = 1 + kotlin.math.max(i - 1, twoEggDrop(n - i))

                holder[n] = kotlin.math.min(left, right)
            }
        }


        return holder[n]
    }
}