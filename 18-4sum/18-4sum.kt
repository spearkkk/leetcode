class Solution {
    private fun seek(nums: IntArray, target: Long, base: Int): MutableList<List<Int>> {
        var start = base + 1
        var end = nums.size - 1

        val result = mutableListOf<List<Int>>()

        /// 중간에 하나의 값이 있어야 한다.
        while (end - start > 1) {
            var center = start + 1

            while (center < end) {
                val sum: Long = nums[start].toLong() + nums[center] + nums[end]

                if (sum == target) {
                    result.add(listOf(nums[base], nums[start], nums[center], nums[end]))
                    center += 1
                    end -= 1
                    continue
                }

                if (target > sum) {
                    center += 1

                } else {
                    end -= 1
                }
            }
            start += 1
            end = nums.size - 1
        }
        return result
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()

        val result = mutableSetOf<List<Int>>()

        /// 4개의 값을 구하는거지만, 실제로 첫번째 요소를 하나씩 먼저 선택한 후 3개의 값을 것과 동일하게 진행한다.
        for (i in 0 .. nums.size - 2) {
            val found = seek(nums, target.toLong() - nums[i], i)
            if (found.isNotEmpty()) {
                result.addAll(found)
            }
        }
        return result.toList()
    }
}
