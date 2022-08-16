class Solution {
    fun plusOne(digits: IntArray): IntArray {
        /// carry가 있을 수 있기 때문에 앞에 0을 삽입한다.
        val result = intArrayOf(0) + digits.copyOf()
        var carry = 1

        for (i in result.indices.reversed()) {
            if (carry < 1) {
                break
            }

            val tmp = result[i] + 1

            result[i] = tmp % 10
            carry = tmp / 10
        }

        /// carry가 발생하지 않았을 경우, leading이 0인 것을 제거해준다.
        return if (result[0] != 0) result else result.sliceArray(1 until result.size)
    }
}