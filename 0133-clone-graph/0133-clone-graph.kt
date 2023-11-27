/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    fun cloneGraph(node: Node?): Node? {
        
        val visited = Array<Node?>(101) { null }

        fun dig(source: Node, target: Node) {
            visited[target.`val`] = target
            
            for (sourceNeighbor in source.neighbors) {
                sourceNeighbor?.let {
                    if (visited[sourceNeighbor.`val`] == null) {
                        val newNeighbor = Node(sourceNeighbor.`val`)
                        target.neighbors.add(newNeighbor)
                        dig(sourceNeighbor, newNeighbor)
                    } else {
                        target.neighbors.add(visited[sourceNeighbor.`val`])
                    }
                }
            }
            
        }

        if (node == null) {
            return null
        }

        val copied = Node(node.`val`)
        dig(node, copied)
        return copied
    }
}