class Solution {
    fun isValid(s: String): Boolean {
        val stack: MutableList<Char> = mutableListOf()

        var str = s
        var isValid = true

        do {
            when (str[0]) {
                '[' -> stack.add('[')
                '{' -> stack.add('{')
                '(' -> stack.add('(')
                ']' -> isValid = stack.isNotEmpty() && stack.removeAt(stack.size - 1) == '['
                '}' -> isValid = stack.isNotEmpty() && stack.removeAt(stack.size - 1) == '{'
                ')' -> isValid = stack.isNotEmpty() && stack.removeAt(stack.size - 1) == '('
            }
            str = str.substring(1)
        } while (isValid && str.isNotEmpty())

        return isValid && stack.isEmpty()
    }
}