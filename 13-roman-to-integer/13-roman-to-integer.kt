class Solution {
    fun romanToInt(s: String): Int {
        var one = 1
        var five = 5
        var ten = 10
        var fiveTen = 50
        var tenTen = 100
        var fiveTenTen = 500
        val tenTenTen = 1000

        var sum = 0

        for (elem in s.reversed()) {
            when (elem) {
                'I' -> sum += one
                'V' -> { sum += five; one *= -1 }
                'X' -> { sum += ten; one *= -1; five *= -1 }
                'L' -> { sum += fiveTen; one *= -1; five *= -1; ten *= -1 }
                'C' -> { sum += tenTen; one *= -1; five *= -1; ten *= -1; fiveTen *= -1 }
                'D' -> { sum += fiveTenTen; one *= -1; five *= -1; ten *= -1; fiveTen *= -1; tenTen *= -1 }
                'M' -> { sum += tenTenTen; one *= -1; five *= -1; ten *= -1; fiveTen *= -1; tenTen *= -1; fiveTenTen *= -1 }
            }
        }

        return sum
    }
}