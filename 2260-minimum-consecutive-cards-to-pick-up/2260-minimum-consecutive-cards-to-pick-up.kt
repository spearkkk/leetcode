class Solution {
    fun minimumCardPickup(cards: IntArray): Int {
        if (cards.size < 2) return -1

        var min = Int.MAX_VALUE

        var right = 0

        val mark = mutableMapOf<Int, Int>()

        while (right < cards.size) {
            val current = cards[right]

            if (mark.containsKey(current)) {
                min = kotlin.math.min(min, right - mark[current]!! + 1)
            }

            mark[current] = right
            right += 1
        }

        return if (min == Int.MAX_VALUE) -1 else min
    }
}