class Solution {
    fun simplifyPath(path: String): String {
        val holder = mutableListOf<String>()
        var cursor = 0
        while (cursor < path.length) {
            val end = path.indexOf('/', cursor)
            val token = if (end < 0)  path.substring(cursor) else path.substring(cursor until end)
            cursor = if (end < 0) path.length else end + 1

            if (token.isEmpty() || token == "." || token == "..") {
                if (token == ".." && holder.isNotEmpty()) {
                    holder.removeAt(holder.size - 1)
                }
                continue
            }

            holder.add(token)
        }


        return "/${holder.joinToString("/")}"
    }
}