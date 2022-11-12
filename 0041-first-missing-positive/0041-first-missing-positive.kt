class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        fun swap(nums: IntArray, left: Int, right: Int) {
            val tmp = nums[left]
            nums[left] = nums[right]
            nums[right] = tmp
        }

        var cursor = 0
        while (cursor < nums.size) {
            // 음수와 배열의 크기보다 큰 수는 고려하지 않는다.
            if (nums[cursor] <= 0 || nums[cursor] > nums.size) {
                cursor += 1
                continue
            }

            // 0번째 인덱스에 1이 들언 경우, i번째 인덱스에 i + 1이 들어간 경우
            // 제대로 위치 했기 때문에 건너 뛴다.
            if (nums[cursor] == cursor + 1) {
                cursor += 1
                continue
            }

            // 현재 가지고 있는 값을 원래 있어야할 위치로 옮긴다.
            // i에 있는 값을 nums[i] - 1으로 옮기는 것이다.
            // 단, nums[i] - 1에 있는 값이 현재 값(nums[i])랑 같다면 무한 루프로 빠지기 때문에 바꾸지 않는다.
            if (nums[nums[cursor] - 1] != nums[cursor]) {
                swap(nums, cursor, nums[cursor] - 1)
                continue
            }

            cursor += 1
        }

        cursor = 0

        while (cursor < nums.size && nums[cursor] - 1 == cursor) {
            cursor += 1
        }
        return cursor + 1
    }
}