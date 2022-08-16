class Solution {
    fun maxProfit(prices: IntArray): Int {
        var valley: Int
        var peak: Int
        var maxProfit = 0

        var cursor = 0
        while (cursor < prices.size - 1) {

            /// cursor 부터 상승 또는 하락이 있을 수 있다. 상승이 되기 전의 최저 지점을 찾는다.
            while (cursor < prices.size - 1) {
                if (prices[cursor] < prices[cursor + 1]) {
                    break
                }
                cursor += 1
            }

            /// 최저 지점의 가격을 저장한다.
            valley = prices[cursor]

            /// 반대로 최저 지점 부터 상승하다가 다시 하락이 되기 전의 최고 지점을 찾는다.
            while (cursor < prices.size - 1) {
                if (prices[cursor] > prices[cursor + 1]) {
                    break
                }
                cursor += 1
            }

            /// 최고 지점의 가격을 저장한다.
            peak = prices[cursor]

            /// 이득을 계산 한 후 그 지점부터 반복한다.
            maxProfit += peak - valley
        }
        return maxProfit
    }
}
