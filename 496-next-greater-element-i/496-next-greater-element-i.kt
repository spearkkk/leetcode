class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val holder = IntArray(10000 + 1) { -1 }
        
        /// num2에서 각 값이 가지는 값보다 큰 값이 있는지 확인하고 이를 배열에 담는다.
        /// 4의 값은 4번째 인덱스에 넣는다.
        for (i in 0 until nums2.size - 1) {
            val cur = nums2[i]
            for (j in i + 1 until nums2.size) {
                if (cur < nums2[j]) {
                    holder[cur] = nums2[j]
                    break
                }
            }
        }

        return nums1.map { holder[it] }.toIntArray()
    }
}