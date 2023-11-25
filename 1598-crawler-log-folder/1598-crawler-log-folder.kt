class Solution {
    fun minOperations(logs: Array<String>): Int {
        val stack: ArrayList<String> = arrayListOf()

        for (log in logs) {
            if (log == "./") {
                continue
            }

            if (log == "../") {
                if(stack.size != 0) {
                    stack.removeLast()
                }
                continue
            }

            stack.add(log)
        }

        return stack.size
    }
}