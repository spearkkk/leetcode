class Solution {
    // binary search
    // https://youtu.be/qWE1cZE-cUE
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {

        // edge case, integer over flow
        if (m.toLong() * k > bloomDay.size) {
            return -1
        }

        var left = 1 // 첫 날
        var right = bloomDay.max()!! // 최대로 큰 날(마지막 날)

        while (left < right) {
            val currentDay = (left + right).shr(1)

            var bucketCount = 0
            var flowerCount = 0

            // check
            for (day in bloomDay) {
                if (currentDay < day) {
                    flowerCount = 0 // 인접해야하기 때문에 피지 못한 꽃을 만나면 카운트를 0으로 만듬
                } else {
                    flowerCount += 1

                    if (flowerCount == k) {
                        bucketCount += 1

                        if (bucketCount == m) {
                            break // 부케를 필요한 만큼 다 만든 경우, 더 만들 필요가 없다.
                        }

                        flowerCount = 0 // 부케를 만들기 위해 다 썼기 때문에 0으로 만듬
                    }
                }
            }

            if (m > bucketCount) {
                left = currentDay + 1 // 만든 부케의 개수가 부족한 경우 current day를 늘린다.
            } else {
                right = currentDay // 만든 부캐의 개수가 만족한 경우, current day를 줄여서 한번 더 체크해본다.
            }
        }
        return left
    }
}