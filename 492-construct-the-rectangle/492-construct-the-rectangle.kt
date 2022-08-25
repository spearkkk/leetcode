class Solution {
    fun constructRectangle(area: Int): IntArray {
        val maxCap = Math.sqrt(area.toDouble()).toInt()

        for (cur in maxCap downTo 1) {
            if (area % cur == 0) {
                return intArrayOf(area / cur, cur)
            }
        }
        return intArrayOf(1, area)
    }
}