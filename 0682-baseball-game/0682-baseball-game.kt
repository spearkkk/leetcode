class Solution {
    fun calPoints(operations: Array<String>): Int {
        val stack = arrayListOf<Int>()

        for (operation in operations) {
            if (operation == "C") {
                if (stack.isNotEmpty()) {
                    stack.removeLast()
                }
                continue
            }

            if (operation == "D") {
                if (stack.isNotEmpty()) {
                    stack.add(stack.last() * 2)
                }
                continue
            }

            if (operation == "+") {
                if (stack.size >= 2) {
                    stack.add(stack[stack.size - 2] + stack.last())
                }
                continue
            }

            stack.add(operation.toInt())
        }

        return stack.sum()
    }
}