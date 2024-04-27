class Solution {
    /**
     * ref.) https://leetcode.com/problems/meeting-rooms-iii/solution/
     *
     * roomAvailabilityTime: n번째 방을 사용하고 있는 회의가 언제 끝나는지 나타내는 배열
     * meetingCount: n번째 방을 사용한 회의의 수
     */

    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        meetings.sortBy { it.first() }

        val roomAvailabilityTime = LongArray(n) { 0L }
        val meetingCount = LongArray(n) { 0L }

        for (meeting in meetings) {
            val (startTime, endTime) = meeting

            var nextTime = Long.MAX_VALUE
            var nextIndex = 0

            var assigned = false

            for (i in 0 until n) {
                // i 번째의 방을 현재 회의에 할당할 수 있다면 할당한다.
                if (roomAvailabilityTime[i] <= startTime) {
                    assigned = true

                    roomAvailabilityTime[i] = endTime + 0L // start time에 할당했기 때문에 지연 없이 end time에 끝날 수 있다.
                    meetingCount[i] += 1 + 0L

                    break
                }

                // 회의의 start time 보다 빨리 끝나는 회의가 없다면 제일 먼저 회의가 끝나는 방을 찾아야 한다.
                // 각 회의의 끝나는 시간 중에 최솟값을 가지는 데이터를 저장해놓는다.
                if (roomAvailabilityTime[i] < nextTime) {
                    nextTime = roomAvailabilityTime[i]
                    nextIndex = i
                }
            }

            // 비어 있는 방이 없어 회의를 할당하지 못했다
            // 이때 제일 먼저 회의가 끝나는 방의 정보를 알기 때문에 해당 방에 강제로 할당한다.
            // 1초씩 증가하는 것이 아니라 바로 다음에 올 회의를 할당하는 것이다. -> 성능 확보
            if (!assigned) {
                roomAvailabilityTime[nextIndex] += endTime - startTime + 0L // start time에 시작하지 못했기 때문에 지연이 발생한다.
                meetingCount[nextIndex] += 1L
            }
        }

        var maxCountIndex = 0
        var maxCount = meetingCount[maxCountIndex]
        for (i in 1 until n) {
            if (maxCount < meetingCount[i]) {
                maxCount = meetingCount[i]
                maxCountIndex = i
            }
        }

        return maxCountIndex
    }
}