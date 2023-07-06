class Solution {
    private fun dig(index: Int, count: Int, ratings: IntArray, counts: IntArray): IntArray {
        if (index == ratings.size) {
            return counts
        }

        var flag = 0
        val newCount = if (ratings[index - 1] == ratings[index]) {
            flag = -1
            1
        } else if (ratings[index - 1] > ratings[index]) {
            flag = 0
            1
        } else {
            flag = 1
            count + 1
        }
        counts[index] = newCount
        val tmp =  dig(index + 1, newCount, ratings, counts)

        if (flag == 0 && counts[index - 1] <= counts[index]) {
            counts[index - 1] = counts[index] + 1
        }
        return tmp
    }

    fun candy(ratings: IntArray): Int {
        val counts = IntArray(ratings.size)
        counts[0] = 1
        dig(1, 1, ratings, counts)
        return counts.sum()
    }
}