class Solution {
    fun permute(nums: IntArray): List<List<Int>> {

        val answers = mutableListOf<List<Int>>()

        val answer = IntArray(nums.size)

        fun bt(cursor: Int) {
            if (cursor >= nums.size) {
                answers.add(answer.toList())
                return
            }

            for (i in nums.indices) {
                if (nums[i] == Int.MIN_VALUE) {
                    continue
                }

                answer[cursor] = nums[i]
                nums[i] = Int.MIN_VALUE
                bt(cursor + 1)

                nums[i] = answer[cursor]
            }
        }

        bt(0)

        return answers
    }
}