class Solution {
    /**
     * 현재 위치의 값이 주어진 값인 `val`과 같다면 유요한 위치(limit)의 마지막 값으로 변경한다. 단, 현재 위치의 index 값은 변하지 않음.
     * 그리고 limit 를 감소시킨다.
     *
     * `val`과 다르다면 현재 위치의 index 를 증가 시킨다.
     */
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var currentIndex = 0
        var limit = nums.size

        while (currentIndex < limit) {
            if (nums[currentIndex] == `val`) {
                nums[currentIndex] = nums[limit - 1]
                nums[limit - 1] = -1
                limit -= 1
            } else {
                currentIndex += 1
            }
        }

        return limit
    }
}
