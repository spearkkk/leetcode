class Solution {
    fun lengthLongestPath(input: String): Int {
        val currentPath = mutableMapOf<Int, String>()

        var tabCount = 0
        var cursor = 0

        var max = 0

        while (cursor < input.length) {
            val nextIndex = input.indexOf("\n", cursor, true)

            val nextToken = input.substring(cursor, if (nextIndex == -1) input.length else nextIndex)
//            println(nextToken)

            var anotherCursor = 0
            while (true) {
                if (nextToken[anotherCursor] == '\t') {
                    tabCount += 1
                    anotherCursor += 1
                    continue
                }

                if (nextToken[anotherCursor] != '\t') {
                    break
                }
                anotherCursor += 1
            }
            val realNextToken = nextToken.substring(anotherCursor)

            currentPath[tabCount] = realNextToken
            if (realNextToken.contains('.')) {
                val filePath = (0 .. tabCount).map { currentPath[it] }.joinToString("/")
                if (filePath.length > max) {
                    max = filePath.length
                }
            }

            tabCount = 0

            if (nextIndex == -1) {
                break
            }
            cursor = nextIndex + 1
        }

        return max
    }
}