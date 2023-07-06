class Solution {
    private fun dig(index: Int, count: Int, ratings: IntArray, counts: IntArray): IntArray {
        if (index == ratings.size) {
            return counts
        }

        // 이웃에 대한 상태를 마킹한다.
        // -1: 이웃이 같은 값일 때
        // 0: 왼쪽 이웃이 오른쪽보다 더 클 때
        // 1: 왼쪽 이웃이 오른쪽보다 더 작을 때
        val flag: Int
        val newCount = if (ratings[index - 1] == ratings[index]) {
            flag = -1
            1
        } else if (ratings[index - 1] > ratings[index]) {
            flag = 0
            1
        } else {
            flag = 1
            count + 1
        }
        counts[index] = newCount
        
        // 왼쪽에서 오른쪽으로 가면서 사탕을 나눠준다.
        val tmp =  dig(index + 1, newCount, ratings, counts)

        // 위의 결과에서 왼쪽이웃이 오른쪽보다 더 클 때에는 사탕을 하나라도 더 가져야 하기 때문에 이를 맞춰준다.
        if (flag == 0 && counts[index - 1] <= counts[index]) {
            counts[index - 1] = counts[index] + 1
        }
        return tmp
    }

    fun candy(ratings: IntArray): Int {
        val counts = IntArray(ratings.size)
        counts[0] = 1
        dig(1, 1, ratings, counts)
        return counts.sum()
    }
}