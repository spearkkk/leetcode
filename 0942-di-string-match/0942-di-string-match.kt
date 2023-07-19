class Solution {
    fun diStringMatch(s: String): IntArray {
        val numbers = (0 .. s.length).toMutableList()

        val result = arrayListOf<Int>()
        for (cur in s) {
            if (cur == 'I') {
                result.add(numbers.first())
                numbers.removeAt(0)
                continue
            }

            result.add(numbers.last())
            numbers.removeAt(numbers.lastIndex)
        }

        result.add(numbers.first())
        
        return result.toIntArray()
    }
}