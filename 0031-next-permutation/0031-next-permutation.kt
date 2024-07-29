class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        /**
         * https://youtu.be/mbOl9qPedDo?si=-G-o9_N0SVZ6FOeH
         * 1, 3, 9, 4, 8, 7, 6, 2, 1
         * 1, 3, 9, 6, 1, 2, 4, 7, 8
         *
         * 뒤에서부터 탐색한다.
         * 탐색은 오름차순이 깨지는 시점이다.
         * 위의 예에서는 4와 8 사이의 시점이다.
         * 오름차순이 깨진 순간이라는 것은 4보다 뒤에 있는 숫자들 사이에서 4보단 큰 수 있다는 것을 의미한다.
         *
         * 따라서 뒤에 있는 수들 중에서 4보다 큰 수를 골라 이 4랑 해당 수를 바꿔준다.
         * 문제 조건에 따라 4보다 큰 수들 중에서 제일 작은 값, 그리고 가장 뒤에 있는 수를 선택하면 된다.
         * 위의 예에서는 6이다.
         */

        var cursor = nums.size - 2
        while (cursor >= 0 && nums[cursor] >= nums[cursor + 1]) {
            cursor -= 1
        }

        // cursor == -1 이면 해당 값은 뒤에서부터 오름차순으로이다. 즉, 제일 큰 값이다.
        if (cursor != -1) {
            var anotherCursor = nums.size - 1
            while (nums[cursor] >= nums[anotherCursor]) {
                anotherCursor -= 1
            }

            val tmp = nums[cursor]
            nums[cursor] = nums[anotherCursor]
            nums[anotherCursor] = tmp
        }

        var left = cursor + 1
        var right = nums.size - 1
        while (left < right) {
            val tmp = nums[left]
            nums[left] = nums[right]
            nums[right] = tmp

            left += 1
            right -= 1
        }
//        println(nums.joinToString(", "))
    }
}