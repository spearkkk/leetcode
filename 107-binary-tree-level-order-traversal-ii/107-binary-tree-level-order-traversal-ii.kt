/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    private fun probe(map: MutableMap<Int, List<Int>>, level: Int, nodes: MutableList<TreeNode?>) {
        val values: MutableList<Int> = mutableListOf()
        val childNodes: MutableList<TreeNode?> = mutableListOf()

        for (node in nodes) {
            if (node != null) {
                values.add(node.`val`)
                childNodes.add(node.left)
                childNodes.add(node.right)
            }
        }

        if (values.size == 0) {
            return
        }

        map[level] = values

        return probe(map, level + 1, childNodes)
    }

    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val levelToValues: MutableMap<Int, List<Int>> = mutableMapOf()

        probe(levelToValues, 0, mutableListOf(root))


        val result: MutableList<List<Int>> = mutableListOf()
        for (level in levelToValues.keys.reversed()) {
            result.add(levelToValues[level]!!)
        }
        return result

//        return map.entries.stream().sorted(Comparator.comparingInt { entry -> entry.key })
//                .map { entry -> entry.value.toList() }
//                .collect(Collectors.toList())
    }
}