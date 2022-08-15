class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        var start = 0
        var end = nums.size - 1

        var result = Int.MAX_VALUE

        /// 중간의 값이 하나 있어야 하기 때문에
        while (end - start > 1) {
            var center = start + 1

            while (center < end) {
                val sum = nums[start] + nums[center] + nums[end]
                if (sum == target) {
                    return sum
                } else if (sum < target){
                    center += 1
                } else {
                    end -= 1
                }

                if (kotlin.math.abs(target - result) > kotlin.math.abs(target - sum)) {
                    result = sum
                }
            }
            /// 시작 지점을 한칸 앞으로 이동 후, 마지막 지점을 다시 맨 뒤로 이동한다.
            start += 1
            end = nums.size - 1
        }

        return result
    }
}













