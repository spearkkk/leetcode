class Solution {
    fun isUgly(n: Int): Boolean {
        if (n <= 0) {
            return false
        }

        var candidate = n
        do {
            if (candidate == 1) {
                return true
            }

            if (candidate % 2 == 0) {
                candidate /= 2
                continue
            }
            if (candidate % 3 == 0) {
                candidate /= 3
                continue
            }
            if (candidate % 5 == 0) {
                candidate /= 5
                continue
            }
            return false
        } while (candidate > 1)
        return true
    }
}
