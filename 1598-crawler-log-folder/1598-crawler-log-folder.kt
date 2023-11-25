class Solution {
    fun minOperations(logs: Array<String>): Int {
        var cnt = 0

        for (log in logs) {
            if (log == "./") {
                continue
            }

            if (log == "../") {
                cnt--
                if (cnt < 0) {
                    cnt = 0
                }
                continue
            }

            cnt++
        }

        return cnt
    }
}