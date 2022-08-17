class Solution {
    fun addDigits(num: Int): Int {
        var sum = num
        do {
            sum = sum.toString().map { Character.getNumericValue(it) }.sum()
        } while (sum / 10 != 0)
        return sum
    }
}
