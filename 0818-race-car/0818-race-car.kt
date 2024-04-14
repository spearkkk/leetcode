class Solution {
    fun racecar(target: Int): Int {

        val visited = mutableSetOf<Pair<Long, Int>>()

        val queue = mutableListOf<Pair<Pair<Long, Int>, Int>>()

        queue.add(Pair(Pair(0, 1), 0))
//        val a = 2L
//        println(a.shl(10))
//        println(a.shl(45))

        while (queue.isNotEmpty()) {

            val (cur, sec) = queue.removeFirst()

            if (visited.contains(cur)) {
                continue
            }

            if (cur.first == target + 0L) {
                return sec
            }

            visited.add(cur)
//            println("cur: $cur, sec: $sec")


            if (!visited.contains(Pair(cur.first + cur.second, cur.second * 2))) {
              // 가지 치기...
                if (0 < cur.first + cur.second && cur.first + cur.second < target.shl(1)) {
                    queue.add(Pair(Pair(cur.first + cur.second, cur.second * 2), sec + 1)) // A
                }
            }

            if (!visited.contains(Pair(cur.first, if (cur.second > 0) -1 else 1))) {
              // 가지 치기...
                if (0 < cur.first && cur.first < target.shl(1)) {
                    queue.add(Pair( Pair(cur.first, if (cur.second > 0) -1 else 1), sec + 1)) // R
                }
            }
        }
        return -1
    }
}