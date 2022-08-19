class Solution {
    fun findRelativeRanks(score: IntArray): Array<String> {
        val rank: Array<String> = Array(score.size) { "" }

        val holder: SortedMap<Int, Int> = sortedMapOf()

        score.forEachIndexed { index, scr -> holder[scr] = index }

        var currentRank: Int = score.size
        holder.forEach { _, index -> rank[index] = applyMedal(currentRank); currentRank -= 1 }
        return rank
    }

    private fun applyMedal(rank: Int): String {
        return when (rank) {
            1 -> "Gold Medal"
            2 -> "Silver Medal"
            3 -> "Bronze Medal"
            else -> rank.toString()
        }
    }
}