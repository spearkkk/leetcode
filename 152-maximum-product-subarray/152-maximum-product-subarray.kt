class Solution {
    private var max = Int.MIN_VALUE

    // matrix 를 만드는데, 반쪽 행렬을 만든다.
    // 그러나 데이터를 다 저장할 필요가 없다. 왜냐하면 maximum 값만 비교하면 되니깐.
    // i가 행, j가 열이면 행마다의 maximum 값을 구한다고 생각하자.
    fun maxProduct(nums: IntArray): Int {
        for (cursor in nums.indices) {
            var currentValue = 1
            for (secondCursor in cursor until nums.size) {

                /// 현재 커서와 두번째 커서가 같은 위치이면 곱하기 전의 초기의 상태이다.
                /// 따라서 최댓값를 갱신하고 현재 위치으로 값을 갱신한다.
                if (cursor == secondCursor) {
                    if (max < nums[cursor]) {
                        max = nums[cursor]
                    }
                    currentValue *= nums[cursor]
                    continue
                }

                currentValue *= nums[secondCursor]

                if (max < currentValue) {
                    max = currentValue
                }
            }
        }
        return max
    }
}
