class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        val holder = s.toMutableList()
        for (cur in t) {
            if (holder.isEmpty()) {
                return true
            }
            if (holder[0] == cur) {
                holder.removeAt(0)
            }
        }

        return holder.isEmpty()
    }
}