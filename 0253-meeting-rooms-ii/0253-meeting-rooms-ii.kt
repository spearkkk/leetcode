class Solution {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        val meetings = java.util.PriorityQueue<Pair<Int, Int>>((compareBy<Pair<Int, Int>> { it.first }).then(compareBy<Pair<Int, Int>> { it.second }))
        for (interval in intervals) {
            meetings.add(Pair(interval[0], interval[1]))
        }

        val pending = java.util.PriorityQueue<Pair<Int, Int>>((compareBy<Pair<Int, Int>> { it.first }).then(compareBy<Pair<Int, Int>> { it.second }))
        val rooms = arrayListOf<Int>()

        var sec = 0
        var cnt = 0

        while (meetings.isNotEmpty()) {
            while (pending.isNotEmpty() && pending.first().first == sec) {
                val (ignore, roomNo) = pending.remove()
                rooms.add(roomNo)
            }

            while (meetings.isNotEmpty() && meetings.first().first == sec) {
                val (ignore, endTime) = meetings.remove()
                if (rooms.isNotEmpty()) {
                    pending.add(Pair(endTime, rooms.removeFirst()))
                } else {
                    pending.add(Pair(endTime, cnt))
                    cnt += 1
                }
            }
//            println("sec: $sec, cnt: $cnt, rooms: ${rooms.joinToString(" ")}, pending: ${pending.joinToString(" ")}")
            val tmp1 = if (pending.isNotEmpty()) pending.first().first else sec + 1
            val tmp2 = if(meetings.isNotEmpty()) meetings.first().first else sec + 1
            sec = kotlin.math.min(tmp1, tmp2)
        }

        return cnt
    }
}