class Solution {
    private fun getAllHours(n: Int): List<Int> {
        return when (n) {
            0 -> listOf(0)
            1 -> listOf(1, 2, 4, 8)
            2 -> listOf(3, 5, 6, 9, 10)
            3 -> listOf(7, 11)
            else -> emptyList()
        }

    }

    private fun getAllMunites(n: Int): List<Int> {
        return when (n) {
            0 -> listOf(0)
            1 -> listOf(1, 2, 4, 8, 16, 32)
            2 -> listOf(3, 5, 9, 17, 33, 6, 10, 18, 34, 12, 20, 36, 24, 40, 48)
            3 -> listOf(7, 11, 19, 35, 13, 21, 37, 25, 41, 49, 14, 22, 38, 26, 42, 50, 28, 44, 52, 56)
            4 -> listOf(15, 23, 39, 27, 43, 51, 29, 45, 53, 57, 30, 46, 54, 58)
            5 -> listOf(31, 47, 55, 59)
            else -> emptyList()
        }
    }

    fun readBinaryWatch(turnedOn: Int): List<String> {
        val result = mutableListOf<Int>()

        for (i in 0 .. turnedOn) {
            for (hour in getAllHours(i)) {
                for (minute in getAllMunites(turnedOn - i)) {
                    result.add(hour * 100 + minute)
                }
            }
        }

        return result.sorted().map { "${it / 100}:${"%02d".format(it % 100)}" }
    }
}