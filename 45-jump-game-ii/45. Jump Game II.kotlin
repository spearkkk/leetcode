class Solution {
    private fun doJumping(current: Int, tried: IntArray, nums: IntArray): Int {
        /// 점프를 다 했기 때문에, 저장한 점프의 수를 반환한다.
        if (current < 0) {
            return tried[0]
        }

        val maximum: Int = nums[current]

        /// 점프를 할 수 없는 상황일 경우 스킵한다. 최댓값으로 설정해서 결과에 무시하도록 한다.
        if (maximum == 0) {
            tried[current] = 10001
            return doJumping(current - 1, tried, nums)
        }

        val goal: Int = nums.size - 1

        if ((maximum + current) >= goal) {
            /// 한 번의 점프로 목표 지점인 마지막 인덱스까지 갈 수 있는 경우
            tried[current] = 1
        } else {
            /// 갈 수 없는 경우, 1부터 maximum까지 점프를 할 경우를 다 확인한다. 점프 수의 합이 최솟값인 지점을 찾는다.
            // tried[current] = ((1 .. maximum).map { current + it }.filter { it < tried.size }.map { tried[it] }.minOrNull() ?: 10001) + 1
            tried[current] = ((1 .. maximum).map { current + it }.filter { it < tried.size }.map { tried[it] }.min() ?: 10001) + 1
        }
        return doJumping(current - 1, tried, nums)
    }

    fun jump(nums: IntArray): Int {
        /// nums.size - 2: 마지막 인덱스는 도착지점이기 때문에 확인하지 않는다.
        return doJumping(nums.size - 2, IntArray(nums.size) { 0 }, nums)
    }
}
