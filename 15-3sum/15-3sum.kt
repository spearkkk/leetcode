class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        var start = 0
        var end = nums.size - 1

        val result = mutableSetOf<List<Int>>()

        /// 중간의 값이 하나 있어야 하기 때문에
        while (end - start > 1) {
            var center = start + 1

            while (center < end) {
                val sum = nums[start] + nums[center] + nums[end]
                if (sum == 0) {
                    result.add(listOf(nums[start], nums[center], nums[end]))
                    center += 1
                    end -= 1
                } else if (sum < 0){
                    center += 1
                } else {
                    end -= 1
                }
            }
            /// 시작 지점을 한칸 앞으로 이동 후, 마지막 지점을 다시 맨 뒤로 이동한다.
            start += 1
            end = nums.size - 1
        }

        return result.toList()
    }
}













