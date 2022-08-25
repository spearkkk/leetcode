class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val footprint = HashMap<Char, String>()

        val splits = s.split(' ')

        if (pattern.length != splits.size) {
            return false
        }

        for (cursor in pattern.indices) {
            val currentPattern: Char = pattern[cursor]
            val currentSplit: String = splits[cursor].trim()

            if (footprint.containsKey(currentPattern)) {
                if (footprint[currentPattern]!! != currentSplit) {
                    return false
                }
                continue
            } else {
                if (footprint.values.toSet().contains(currentSplit)) {
                    return false
                }
                footprint[currentPattern] = currentSplit
            }
        }
        return true
    }
}
