class Solution {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        val pq = java.util.PriorityQueue<Pair<Int, Int>>((compareBy<Pair<Int, Int>> { it.first }.then(compareBy { it.second })))
        for (interval in intervals) {
            pq.add(Pair(interval[0], interval[1]))
        }

        var stamp = 0

        while (pq.isNotEmpty()) {
            val (startTime, endTime) = pq.remove()
            if (stamp > startTime) {
                return false
            }
            stamp = endTime
        }
        return true
    }
}