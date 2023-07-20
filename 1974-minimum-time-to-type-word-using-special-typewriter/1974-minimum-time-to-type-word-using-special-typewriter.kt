import kotlin.math.abs

class Solution {
    fun minTimeToType(word: String): Int {

        var current = 'a'
        var result = word.length

        for (w in word) {
            val clockwise = abs( w - current)
            val counterClockwise = 26 - clockwise

            result += if (clockwise < counterClockwise) {
                clockwise
            } else {
                counterClockwise
            }

            current = w
        }

        return result
    }
}