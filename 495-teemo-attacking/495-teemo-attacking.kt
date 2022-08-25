class Solution {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        var sum = 0

        for (i in (0 .. timeSeries.size - 2).reversed()) {
            if (timeSeries[i] + duration < timeSeries[i + 1]) {
                sum += duration
                continue
            }

            sum += timeSeries[i + 1] - timeSeries[i]
        }
        return sum + duration
    }
}