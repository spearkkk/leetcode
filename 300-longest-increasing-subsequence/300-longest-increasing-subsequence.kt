class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        // nums를 역방향(역순)으로 진행하면서 해당 값을 선택했을 때와 선택하지 않았을 때의 카운트를 저장한다.
        // key 값은 현재까지 만든 부분 집합에서 제일 값이 작은 숫자, value 값은 현재까지 만든 부분 집합의 원소 개수
        // holder에는 계속 값이 추가만 되지 사라지지 않는다. 선택하지 않았을 때의 미래에서 선택이 될 수 있어야하고 이 값이 부분 집합이 더 클 수 있다.
        val holder: MutableMap<Int, Int> = mutableMapOf()

        for (reversedCursor in nums.indices.reversed()) {
            val cnt = (holder.filter { it.key > nums[reversedCursor] }.maxBy { it.value }?.value ?: 0) + 1
            holder[nums[reversedCursor]] = cnt
        }

        return holder.maxBy { it.value }?.value ?: 1
    }
}
