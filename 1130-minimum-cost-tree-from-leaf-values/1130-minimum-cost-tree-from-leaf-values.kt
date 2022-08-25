class Solution {
    /// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
    fun mctFromLeafValues(arr: IntArray): Int {
        val holder = Stack<Int>()

        // first left side
        holder.push(Int.MAX_VALUE)

        var sum = 0
        for (cur in arr) {
            while (holder.peek() <= cur) {
                val tmp = holder.pop()

                sum += tmp * if (holder.peek() < cur) holder.peek() else cur
            }
            holder.push(cur)
        }

        while (holder.size > 2) {
            sum += holder.pop() * holder.peek()
        }

        return sum
    }
}