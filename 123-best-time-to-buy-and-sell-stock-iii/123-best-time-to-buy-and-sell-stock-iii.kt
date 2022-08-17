class Solution {
    fun maxProfit(prices: IntArray): Int {
        val forwardProfits = IntArray(prices.size) { 0 }

        var forwardMin = prices[0]
        var forwardMaxProfit = 0

        for (cursor in 1 until prices.size) {
            /// 하락하는 순간이면 최저 지점의 값을 갱신하고 최대 이익도 넣어준다.
            if (forwardMin > prices[cursor]) {
                forwardMin = prices[cursor]
                forwardProfits[cursor] = forwardMaxProfit
                continue
            }
            /// 하락하는 수간이 아니면 최대 이익을 계산한 후, 그 값이 더 크면 최대 이익을 갱신한다.
            if (prices[cursor] - forwardMin > forwardMaxProfit) {
                forwardMaxProfit = prices[cursor] - forwardMin
            }
            
            /// 최대 이익을 넣어준다.
            forwardProfits[cursor] = forwardMaxProfit
        }

        val backwardProfits = IntArray(prices.size) { 0 }
        
        var backwardMax = prices[prices.size - 1]

        for (cursor in (prices.indices).reversed()) {
            /// 거꾸로 갔을 때, 이전 값이 더 크면 최대 값을 갱신한다. 그리고 최대 이익도 갱신한다. 
            if (backwardMax < prices[cursor]) {
                backwardMax = prices[cursor]
                backwardProfits[cursor] = 0
                continue
            }
            
            /// 거꾸로 갔을 떄, 이전 값이 더 작다면 최대 이익을 계산해서 갱신한다.
            backwardProfits[cursor] = backwardMax - prices[cursor]
        }

        var result = Int.MIN_VALUE
        for (cursor in prices.indices) {
            if (result < forwardProfits[cursor] + backwardProfits[cursor]) {
                result = forwardProfits[cursor] + backwardProfits[cursor]
            }
        }

        return result
    }
}
