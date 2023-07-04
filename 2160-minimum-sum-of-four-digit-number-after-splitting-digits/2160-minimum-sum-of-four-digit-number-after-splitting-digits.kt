class Solution {
    fun minimumSum(num: Int): Int {
        val numbers = ArrayList<Int>()
        numbers.add(num / 1000)
        numbers.add((num % 1000) / 100)
        numbers.add((num % 100) / 10)
        numbers.add((num % 10))

        numbers.sort()
        return (numbers[0] + numbers[1]) * 10 + (numbers[2] + numbers[3])
    }
}