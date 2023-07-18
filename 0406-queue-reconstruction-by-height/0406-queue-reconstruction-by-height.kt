import java.util.*
import kotlin.Comparator

class Solution {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        val comparator: Comparator<IntArray> = Comparator { l, r ->
            if (l[0] == r[0]) l[1] - r[1] else r[0] - l[0]
        }

        people.sortWith(comparator)

        val result: LinkedList<IntArray> = LinkedList<IntArray>()
        for (cur in people) {
            result.add(cur[1], cur)
        }

        return result.toTypedArray()
    }
}

