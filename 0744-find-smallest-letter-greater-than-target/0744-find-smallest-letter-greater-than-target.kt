class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        val t = target - 'a'

        val max = letters[letters.size - 1] - 'a'
        if (max < t) {
            return letters[0]
        }

        var leftCursor = 0

        while (true) {
            if (leftCursor >= letters.size) {
                return letters[0]
            }
            
            val min = letters[leftCursor] - 'a'
            if (t < min) {
                return letters[leftCursor]
            }
            leftCursor += 1
        }
    }
}