class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        
        for (i in prices.indices) {
            /// 현재 가격이 최소 가격보다 싸다면 갱신한다.
            if (prices[i] < minPrice) {
                minPrice = prices[i]
            } else if (prices[i] - minPrice > maxProfit) {
                /// 현재 가격에 팔았을 때의 이익과 기존의 이익을 비교해서 이익이 크다면 갱신한다.
                maxProfit = prices[i] - minPrice
            }
        }
        return maxProfit
    }
}