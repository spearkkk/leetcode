class Solution {
    private fun generate(cur: String, openedCount: Int, closedCount: Int, n: Int, holder: MutableList<String>) {
        /// 닫은 괄호의 수가 n과 같으면 다 만든 것이기 때문에 결과에 저장한다.
        if (closedCount == n) {
            holder.add(cur)
            return
        }

        /// 연 괄호의 수가 닫은 괄호의 수보다 많으면, 괄호를 닫을 수 있다.
        if (openedCount > closedCount) {
            generate("$cur)", openedCount, closedCount + 1, n, holder)
        }
        /// 연 괄호의 수가 n보다 작으면, 괄호를 더 열을 수 있다.
        if (openedCount < n) {
            generate ("$cur(", openedCount + 1, closedCount, n, holder)
        }
    }

    fun generateParenthesis(n: Int): List<String> {
        val holder = mutableListOf<String>()
        generate("", 0, 0, n, holder)

        return holder.toList()
    }
}