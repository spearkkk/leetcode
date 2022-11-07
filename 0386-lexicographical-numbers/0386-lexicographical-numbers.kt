class Solution {
    fun lexicalOrder(n: Int): List<Int> {
        fun order(n: Int, base: Int): List<Int> {
            val nums = mutableListOf<Int>()
            for (cursor in 0 .. 9) {
                val current = base * 10 + cursor
                if (current > n) {
                    break
                }
                nums.add(current)
                nums.addAll(order(n, current))
            }

            return nums
        }

        val result = mutableListOf<Int>()
        for (cursor in 1 .. 9) {
            if (cursor > n) {
                break
            }
            result.add(cursor)
            result.addAll(order(n, cursor))
        }

        return result
    }
}