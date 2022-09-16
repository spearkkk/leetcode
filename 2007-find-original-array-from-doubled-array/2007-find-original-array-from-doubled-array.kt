class Solution {
    fun findOriginalArray(changed: IntArray): IntArray {
        if (changed.isEmpty() || changed.size % 2 == 1) {
            return intArrayOf()
        }

        val counter = sortedMapOf<Int, Int>()
        for (elem in changed) {
            counter[elem] = (counter[elem]?: 0) + 1
        }

        val result = mutableListOf<Int>()
        for (key in counter.keys) {
            if (counter[key]!! > (counter[key + key]?: 0)) {
                return intArrayOf()
            }

            /// edge case
            if (key!! == 0) {
                repeat(counter[key]!! / 2) {
                    result.add(0)
                }
                counter[0] = 0
                continue
            }

            repeat(counter[key]!!) {
                result.add(key)
                counter[key + key] = counter[key + key]!! - 1
            }
        }

        return result.toIntArray()
    }
}