
class Solution {
    private fun permute2(nums: IntArray): List<List<Int>> {
        if (nums.size == 2) {
            return listOf(listOf(nums[0], nums[1]), listOf(nums[1], nums[0]))
        }

        val nextResult = mutableListOf<List<Int>>()
        
        /// 각 값이 맨 처음에 나올 경우를 다 계산한다.
        for (cursor in nums.indices) {
            val currentValue = nums[cursor]
            
            /// 나머지 배열의 값들로 재귀 반복
            val currentResult = permute2(nums.withIndex().filter { it.index != cursor }.map { it.value }.toIntArray())

            /// 위에서 구한 결과에 맨 앞에 위의 값을 넣는다.
            for (i in currentResult) {
                val last = i.toMutableList()
                last.add(0, currentValue)
                nextResult.add(last)
            }
        }


        return nextResult
    }
    fun permute(nums: IntArray): List<List<Int>> {
        /// 엣지 케이스
        if (nums.size < 2) {
            return listOf(nums.toList())
        }
        return permute2(nums)
    }
}
