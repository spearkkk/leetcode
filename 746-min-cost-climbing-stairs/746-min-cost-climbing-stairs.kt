class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {

        if (cost.size == 2) {
            return if (cost[0] < cost[1]) cost[0] else cost[1]
        }

        val holder = IntArray(cost.size) { 0 }
        holder[cost.size - 2] = cost[cost.size - 2]
        holder[cost.size - 1] = cost[cost.size - 1]

        for (i in (0 until  cost.size - 2).reversed()) {
            val candi1 = holder[i + 1]
            val candi2 = holder[i + 2]

            holder[i] = (if (candi1 < candi2) candi1 else candi2) + cost[i]
        }

        return if (holder[0] < holder[1]) holder[0] else holder[1]
    }
}