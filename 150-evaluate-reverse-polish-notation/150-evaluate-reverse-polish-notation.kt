class Solution {
    private fun doCal(left: String, right: String, op: String): String {
        val leftInt = left.toInt()
        val rightInt = right.toInt()

        return when (op) {
            "+" -> leftInt + rightInt
            "-" -> leftInt - rightInt
            "*" -> leftInt * rightInt
            "/" -> leftInt / rightInt
            else -> {0}
        }.toString()
    }

    private val ops = mutableSetOf("+", "-", "*", "/")

    fun evalRPN(tokens: Array<String>): Int {
        if (tokens.size < 3) {
            if (tokens.size == 1) {
                return tokens[0].toInt()
            }
            return 0
        }

        val stack = mutableListOf(tokens[0], tokens[1])
        var cursor = 2

        while (cursor < tokens.size) {
            if (ops.contains(tokens[cursor])) {
                val right = stack.removeAt(stack.size - 1)
                val left = stack.removeAt(stack.size - 1)
                stack.add(doCal(left, right, tokens[cursor]))
            } else {
                stack.add(tokens[cursor])
            }
            cursor += 1
        }
        return stack.removeAt(0).toInt()
    }
}