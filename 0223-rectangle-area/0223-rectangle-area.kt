class Solution {
    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        val a = (ax2 - ax1) * (ay2 - ay1)
        val b = (bx2 - bx1) * (by2 - by1)

        val overlapedX = kotlin.math.max(kotlin.math.min(ax2, bx2) - kotlin.math.max(ax1, bx1), 0)
        val overlapedY = kotlin.math.max(kotlin.math.min(ay2, by2)  - kotlin.math.max(ay1, by1), 0)
        val overlap = overlapedX * overlapedY
        
        return a + b - overlap
    }
}