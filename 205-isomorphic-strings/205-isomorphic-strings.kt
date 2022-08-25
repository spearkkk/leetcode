class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val holder = hashMapOf<Char, Char>()
        val holder2 = hashMapOf<Char, Char>()

        for (i in s.indices) {
            if (holder.containsKey(s[i]) && holder[s[i]] != t[i] ) {
                return false
            }
            if (holder2.containsKey(t[i]) && holder2[t[i]] != s[i] ) {
                return false
            }

            if (!holder.containsKey(s[i])) {
                holder[s[i]] = t[i]
            }
            if (!holder2.containsKey(t[i])) {
                holder2[t[i]] = s[i]
            }
        }
        return true
    }
}
