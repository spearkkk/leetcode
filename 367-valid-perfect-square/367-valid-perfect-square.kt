class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        val maximum = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2
        val candidates = (1 .. maximum).map{x -> x * x}.toSet()
        return candidates.contains(num)
    }
}