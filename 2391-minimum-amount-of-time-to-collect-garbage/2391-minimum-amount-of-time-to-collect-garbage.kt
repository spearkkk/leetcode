class Solution {
    private val PLASTIC = 0
    private val GLASS = 1
    private val METAL = 2
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        val trucks = arrayOf(Pair(-1, 0), Pair(-1, 0), Pair(-1, 0))

        for (cursor in garbage.indices) {
            for (c in garbage[cursor]) {
                when (c) {
                    'P' -> trucks[PLASTIC] = Pair(cursor, trucks[PLASTIC].second + 1)
                    'G' -> trucks[GLASS] = Pair(cursor, trucks[GLASS].second + 1)
                    else -> trucks[METAL] = Pair(cursor, trucks[METAL].second + 1)
                }
            }
        }

        fun cost(truck: Pair<Int, Int>): Int {
            if (truck.first < 0) {
                return 0
            }

            var c = truck.second
            for (i in 0 until truck.first) {
                c += travel[i]
            }
            return c
        }

        var answer = 0
        for (i in PLASTIC .. METAL) {
            answer += cost(trucks[i])
        }

        return answer
    }
}