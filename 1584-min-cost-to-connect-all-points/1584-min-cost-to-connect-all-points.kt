class Solution {
    private class EdgePoint(
        val from: Int, // Index of first point
        val to: Int,   // Index of another point
        val cost: Int  // Cost between points
    )

    private fun buildGraph(points: Array<IntArray>): java.util.PriorityQueue<EdgePoint> {
        val edges = java.util.PriorityQueue<EdgePoint> { o1, o2 -> o1.cost - o2.cost } // Compare by costs
        for (i in points.indices) {
            val (x1, y1) = points[i]
            for (j in i + 1 until points.size) { // We add ALL of vertex to our PQ.
                val (x2, y2) = points[j]
                val cost = Math.abs(x2 - x1) + Math.abs(y2 - y1) // Calculate costs
                val edgePoint = EdgePoint(i, j, cost)
                edges.offer(edgePoint)
            }
        }
        return edges
    }

    private class UFMinConst(n: Int) {
        private val array = Array(n) { it }
        fun union(x1: Int, x2: Int) {
            val p1 = find(x1)
            val p2 = find(x2)
            if (p1 == p2) return
            array[p1] = p2
        }

        fun find(x: Int): Int {
            if (array[x] == x) return x
            val parent = find(array[x])
            array[x] = parent
            return parent
        }

        fun connected(x1: Int, x2: Int): Boolean = find(x1) == find(x2)

    }

    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val graph = buildGraph(points) // Implelemtation above
        val uf = UFMinConst(points.size) // Implelemtation above
        var costMst = 0 // Our MST, but need only cost
        while (graph.isNotEmpty()) {
            val edge = graph.poll()
            if (uf.connected(edge.from, edge.to).not()) { // no need to add cycles =)
                uf.union(edge.from, edge.to)
                costMst += edge.cost
            }
        }
        return costMst
    }   
}