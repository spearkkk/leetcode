class Solution {
    private val mod = 1_000_000_000 + 7

    fun numOfSubarrays(arr: IntArray): Int {
        var result = 0

        var oddCount = 0
        var evenCount = 1 /// 왜냐하면 홍수 더하기 0은 홀수, 즉 0도 짝수로 카운트해야하기 때문에 1을 넣는다.

        var beforeSum = 0

        for (element in arr) {
            val tmp = element.and(1) /// 현재 값이 홀수인지 아닌지 판단한다.
            beforeSum = beforeSum.xor(tmp) /// 이전 합계와 현재 값이 둘다 홀수 이거나 짝수이면 결과가 짝수이기 때문에 xor 연산의 값은 0, 서로 반대일 때 1이 나온다.

            result = (result + if (beforeSum % 2 == 1) evenCount else oddCount) % mod
            if (beforeSum % 2 == 1) oddCount += 1 else evenCount += 1
        }
        return result
    }
}