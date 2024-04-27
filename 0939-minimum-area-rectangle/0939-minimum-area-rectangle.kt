class Solution {
    /**
     * 어떻게 하면 직사각형을 확인할 수 있을까?
     * 각 지점에서 가질 수 있는 직사각형의 넓이를 구하고 최솟값을 가지고 있으면 될까?
     * 한 지점에서 가장 먼저 만들어지는 직사각형이 최솟값이다.
     *
     * 직사각형을 만들기 위해 서로 같은 선에 위치하지 않은(수평/수직이 아닌) 두 개의 점을 선택한다.
     * 두 점을 잇는 선을 대각선으로 하는 직사각형을 그린다면 나머지 두 개의 점도 찾을 수 있다.
     * 나머지 두 점이 있을 때 면적을 계산할 수 있다.
     *
     */
    fun minAreaRect(points: Array<IntArray>): Int {
        val pts = mutableSetOf<Pair<Int, Int>>()

        val xs = mutableSetOf<Int>()
        val ys = mutableSetOf<Int>()

        for (point in points) {
            val (x, y) = point
            val pt = Pair(x, y)
            pts.add(pt)
            xs.add(x)
            ys.add(y)
        }

        var min = Long.MAX_VALUE
        for (x in xs) {
            for (y in ys) {
                for (aX in xs) {
                    for (aY in ys) {
                        if (aX == x || aY == y) {
                            continue
                        }
                        if (pts.contains(Pair(x, y)) &&
                                pts.contains(Pair(aX, aY)) &&
                                pts.contains(Pair(aX, y)) &&
                                pts.contains(Pair(x, aY))) {
                            min = kotlin.math.min(min, kotlin.math.abs((aX - x) * (aY - y)).toLong())
                        }

                    }
                }
            }
        }

        return if (min == Long.MAX_VALUE) 0 else min.toInt()
    }
}