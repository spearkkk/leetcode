class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if (gas.isEmpty()) {
            return -1
        }

        var leftGas = 0
        var totalLeftGas = 0
        var start = 0

        for (cursor in gas.indices) {
            totalLeftGas += gas[cursor] - cost[cursor]
            leftGas += gas[cursor] - cost[cursor]
            if (leftGas < 0) {
                leftGas = 0
                start = cursor + 1
            }
        }

        return if (totalLeftGas < 0) -1 else start
    }
}