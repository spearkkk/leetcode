class Solution {
    private fun split(nums: IntArray): IntArray {
        var cursor = 0
        var count = 0
        var currentValue = nums[cursor]

        val holder: MutableList<Int> = mutableListOf()

        while (cursor < nums.size) {
            /// 현재 커서의 값과 현재 값이 같다면 카운트와 커서를 증가시킨다.
            if (nums[cursor] == currentValue) {
                count += 1
                cursor += 1
            } else {
                /// 현재 커서의 값과 현재 값이 다르면 카운트와 현재 값을 저장한다
                /// 저장했기 때문에 카운트는 초기화하고 현재 값을 갱신한다.
                holder.add(count)
                holder.add(currentValue)

                count = 0
                currentValue = nums[cursor]
            }
        }

        /// 만약 카운트가 남아 있다면 이를 저장한다.
        if (count != 0) {
            holder.add(count)
            holder.add(currentValue)
        }

        return holder.toIntArray()
    }

    fun countAndSay(n: Int): String {
        if (n == 1) {
            return "1"
        }

        var nums = intArrayOf(1)
        for (i in 2..n) {
            nums = split(nums)
        }
        return nums.joinToString("") { i -> i.toString() }
    }
}
