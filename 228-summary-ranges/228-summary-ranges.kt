class Solution {
    private fun convert(min: Int, max: Int): String {
        if (min == max) {
            return min.toString()
        }
        return "$min->$max"
    }
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) {
            return listOf()
        }

        var cursor = 0

        val result = mutableListOf<String>()
        do {
            var count = 0
            while (true) {
                if (cursor + count + 1 < nums.size && nums[cursor + count + 1].toLong() - nums[cursor + count] <= 1L) {
                    count += 1
                    continue
                }
                break
            }
            result.add(convert(nums[cursor], nums[cursor + count]))
            cursor += count + 1

        } while (cursor < nums.size)

        return result
    }
}
