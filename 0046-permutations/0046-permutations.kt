class Solution {
    fun permute(nums: IntArray): List<List<Int>> {

        val answers = mutableListOf<List<Int>>()

        val answer = IntArray(nums.size)
        val visited = BooleanArray(nums.size) { false }

        fun bt(cursor: Int) {
            if (cursor >= nums.size) {
                answers.add(answer.toList())
                return
            }

            for (i in nums.indices) {
                if (visited[i]) {
                    continue
                }

                answer[cursor] = nums[i]
                visited[i] = true
                bt(cursor + 1)

                visited[i] = false
            }
        }
        
        bt(0)

        return answers
    }
}