class Solution {
    fun maxSubArray(nums: IntArray): Int {
        /// 각 인덱스에서의 최대 합을 가지고 있는 배열을 만든다.
        val sum: MutableList<Int> = MutableList(nums.size) { -100001 }

        for (i in nums.indices) {
            if (i == 0) {
                sum[0] = nums[0]
                continue
            }

            /// 앞의 최대 합과 현재 값을 더 했을 때와 현재 값을 비교한다. 
            if (sum[i - 1] + nums[i] < nums[i]) {
                /// 현재 값이 더 크면 앞의 최대 합을 버린다.
                sum[i] = nums[i]
            } else {
                /// 현재 값과 최대 합을 더했을 때 크면 그 값을 넣는다. 
                sum[i] = sum[i - 1] + nums[i]
            }
        }

        // return sum.maxOrNull()!!
        return sum.max()!!
    }
}
