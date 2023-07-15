class Solution {
    // 1432219
    // 132219
    // 12219
    // 1219

    fun removeKdigits(num: String, k: Int): String {
        val stack = ArrayList<Char>()

        var count = 0
        for (c in num) {

            while (stack.isNotEmpty() && stack.last() - '0' > c - '0' && count < k) {
                stack.removeAt(stack.lastIndex)
                count += 1
            }

            stack.add(c)
        }

        while (count < k && stack.isNotEmpty()) {
            stack.removeAt(stack.lastIndex)
            count += 1
        }

        if (stack.isEmpty()) {
            return "0"
        }

        var result = stack.joinToString("")
        while (result.isNotEmpty() && result[0] == '0') {
            result = result.substring(1)
        }

        return result.ifBlank { "0" }
    }
}