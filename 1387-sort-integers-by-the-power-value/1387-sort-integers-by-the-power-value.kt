class Solution {
    private fun doLogic(n: Int): Int {
        if (n % 2 == 0) {
            return n / 2
        }
        return n * 3 + 1
    }

    fun getKth(lo: Int, hi: Int, k: Int): Int {
        val holder = IntArray(10001) { 0 }

        /// holder에 logic에 맞는 count를 구해서 넣는다.
        for (i in 2 .. hi) {
            if (holder[i] == 0) {
                var tmp = i
                var cnt = 0

                while (tmp != 1) {
                    tmp = doLogic(tmp)
                    cnt += 1
                }

                holder[i] = cnt
            }
        }

        // k번째의 값을 구하기 위해 정렬을 한다.
        val array = ArrayList<Pair<Int, Int>>(hi - lo + 1)
        for (index in lo .. hi) {
            val tmp = Pair(holder[index], index)
            array.add(tmp)

        }

        return array.sortedBy { it.first } [k - 1].second
    }
}