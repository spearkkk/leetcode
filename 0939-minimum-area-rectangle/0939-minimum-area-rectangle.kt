class Solution {
    /**
     * 어떻게 하면 직사각형을 확인할 수 있을까?
     * 각 지점에서 가질 수 있는 직사각형의 넓이를 구하고 최솟값을 가지고 있으면 될까?
     * 한 지점에서 가장 먼저 만들어지는 직사각형이 최솟값이다.
     *
     * 직사각형을 만들기 위해서는 반드시 3개의 지점을 알아야한다.
     * 3개의 점을 알면 나머지 한 지점은 정해져 있다.
     * 각 지점마다 만족하는 3개의 점을 찾으면 불필요하게 찾게 된다.
     * 따라서 기준 지점에서 y 값은 같지만 x값이 증가하는 수 중에서 하나를 선택한다.
     * 그리고 x 값은 같지만 y값이 증가하는 수 중에서 또 다른 하나를 선택한다.
     */
    private val comparator = (compareBy<Pair<Int, Int>> { it.second }).then(compareBy { it.first })
    fun minAreaRect(points: Array<IntArray>): Int {
        val pts = mutableSetOf<Pair<Int, Int>>()

        val pq = java.util.PriorityQueue<Pair<Int, Int>>(comparator)
        val xToYs = Array<MutableList<Int>>(4 * 10_000 + 1) { mutableListOf() }
        val yToXs = Array<MutableList<Int>>(4 * 10_000 + 1) { mutableListOf() }

        for (point in points) {
            val (x, y) = point
            val pt = Pair(x, y)
            pts.add(pt)
            pq.add(pt)

            xToYs[x].add(y)
            yToXs[y].add(x)
        }

        var min = Long.MAX_VALUE
        while (pq.isNotEmpty()) {
            val (x, y) = pq.remove()
//            println("x: $x, y: $y")
            for (aX in yToXs[y]) {
                for (aY in xToYs[x]) {
                    if (aX <= x ||
                        aY <= y ||
                        !pts.contains(Pair(x, aY)) ||
                        !pts.contains(Pair(aX, y)) ||
                        !pts.contains(Pair(aX, aY))) {
                        continue
                    }
//                    println("x: $x, y: $y, aX: $aY, aY: $aY, min: $min")
                    min = kotlin.math.min(min, ((aX - x) * (aY - y)).toLong())
                }
            }
        }

        return if (min == Long.MAX_VALUE) 0 else min.toInt()
    }
}