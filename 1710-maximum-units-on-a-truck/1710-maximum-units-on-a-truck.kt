class Solution {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        val comparator: Comparator<IntArray> = Comparator { l, r ->
            if (l[1] == r[1]) r[0] - l[0] else r[1] - l[1]
        }

        boxTypes.sortWith(comparator)

        var count = truckSize
        var result = 0
        for (boxType in boxTypes) {
            if (boxType[0] <= count) {
                count -= boxType[0]
                result += boxType[0] * boxType[1]
            } else {
                result += count * boxType[1]
                break
            }
        }
        return result
    }
}