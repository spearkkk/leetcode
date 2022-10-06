class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        fun nextIndex(version: String, startIndex: Int): Int {
            if (startIndex >= version.length) {
                return 501
            }
            val nextIndex = version.indexOf('.', startIndex)
            return if (nextIndex == -1) version.length else nextIndex
        }

        var leftCursor = 0
        var rightCursor = 0
        while (leftCursor < version1.length || rightCursor < version2.length) {
            val nextIndex1 = nextIndex(version1, leftCursor)
            val nextIndex2 = nextIndex(version2, rightCursor)

            val splitVersion1 = if (nextIndex1 == 501) 0 else version1.substring(leftCursor, nextIndex1).toInt()
            val splitVersion2 = if (nextIndex2 == 501) 0 else version2.substring(rightCursor, nextIndex2).toInt()

            if (splitVersion1 == splitVersion2) {
                leftCursor = nextIndex1 + 1
                rightCursor = nextIndex2 + 1
                continue
            }

            return if (splitVersion1 < splitVersion2) -1 else 1
        }
        return 0
    }
}