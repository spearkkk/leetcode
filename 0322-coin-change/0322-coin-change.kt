class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val memoization = IntArray(amount + 1) { amount + 1 }
        memoization[0] = 0

        for (currentAmount in 1 .. amount) {
            for (coin in coins) {
                if (currentAmount >= coin && memoization[currentAmount - coin] < amount + 1) {
                    val tmp = memoization[currentAmount - coin]
                    memoization[currentAmount] = kotlin.math.min(tmp + 1, memoization[currentAmount])
                }
            }
        }

        return if (memoization.last() < amount + 1) memoization.last() else -1
    }
}