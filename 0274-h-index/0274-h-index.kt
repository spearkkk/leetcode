class Solution {
    fun hIndex(citations: IntArray): Int {
        
        for (base in citations.size downTo 0) {
            var cnt = 0
            for (citation in citations) {
                if (base <= citation) {
                    cnt += 1
                }
            }
            if (base <= cnt) {
                return base
            }
        }

        return 0
    }
}