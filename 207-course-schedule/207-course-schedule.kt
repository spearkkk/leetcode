import java.util.*

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val matrix = Array(numCourses) { IntArray(numCourses) { 0 } }
        val marks = IntArray(numCourses) { 0 }

        for (pre in prerequisites) {
            val before = pre[1]
            val after = pre[0]

            matrix[before][after] = 1
            marks[after] += 1
        }

        val queue: Queue<Int> = LinkedList()
        for (cursor in marks.indices) {
            if (marks[cursor] == 0) {
                queue.offer(cursor)
            }
        }

        var count = 0
        while (queue.isNotEmpty()) {
            val current = queue.poll()

            count += 1

            for (cursor in 0 until numCourses) {
                if (matrix[current][cursor] != 0) {
                    marks[cursor] -= 1
                    if (marks[cursor] == 0) {
                        queue.offer(cursor)
                    }
                }
            }
        }

        return count == numCourses
    }
}