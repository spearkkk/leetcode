class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        
        val sum = IntArray(cost.size)
        
        sum[0] = cost[0]
        sum[1] = cost[1]
        
        for (k in 2 until cost.size) {
            sum[k] = cost[k] + kotlin.math.min(sum[k - 1], sum[k - 2])
        }

        return kotlin.math.min(sum[cost.size - 1], sum[cost.size - 2])
    }
}