class Solution {
    private val memoization = mutableMapOf<Int, Int>()

    private fun getNumOfTrees(from: Int, to: Int): Int {
        if (from > to) {
            return 1
        }

        if (memoization.containsKey(to - from)) {
            return memoization[to - from]!!
        }

        var sum = 0
        for (i in from .. to) {
            val leftNodes = getNumOfTrees(from, i - 1)
            val rightNodes = getNumOfTrees(i + 1, to)

            sum += leftNodes * rightNodes
        }

        memoization[to - from] = sum
        return sum
    }

    fun numTrees(n: Int): Int {
        return getNumOfTrees(1, n)
    }
}