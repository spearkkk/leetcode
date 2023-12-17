class Solution {
    fun judgePoint24(cards: IntArray): Boolean {

        // 두 개의 정수를 골랐을 때, 할 수 있는 연산을 모두 해서 반환한다. 두 수의 위치를 변경하는 것도 고려한다.
        fun populateWithCalculation(left: Double, right: Double): List<Double> {
            val holder = mutableListOf<Double>()
            holder.add(left - right)
            holder.add(right - left)

            holder.add(left + right)
//            holder.add(right + right)

            holder.add(left * right)
//            holder.add(right * left)

            if (right != 0.0) {
                holder.add(left / right)
            }
            if (left != 0.0) {
                holder.add(right / left)
            }

            return holder
        }

        fun bt(cur: DoubleArray): Boolean {
            if (cur.size == 1) {
                if (kotlin.math.abs(cur[0] - 24.0) <= 0.1) {
                    return true
                }
                return false
            }


            for (i in cur.indices) {
                for (j in i + 1 until cur.size) {
                    val left = cur[i]
                    val right = cur[j]

                    val next = cur.withIndex().filter { it.index != i && it.index != j }.map { it.value }.toMutableList()

                    for (candi in populateWithCalculation(left, right)) {
                        next.add(candi)
                        if (bt(next.toDoubleArray())) {
                            return true
                        }
                        next.removeLast()
                    }
                }
            }
            return false
        }

        return bt(cards.map { it.toDouble() }.toDoubleArray())
    }
}