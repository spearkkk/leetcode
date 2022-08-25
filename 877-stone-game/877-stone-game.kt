class Solution {
    fun stoneGame(piles: IntArray): Boolean {
        /**
         * 정렬 후, 앞에 두개를 앨리스와 밥이 가져가는 것을 생각하자
         * 솔직히 정렬하면 느려서 통과 못할 줄 알았는데, 됨
         */
        val sorted = piles.sorted()
        var sum = 0
        for ( i in 0 until piles.size / 2) {
            sum += sorted[2 * i + 1] - sorted[2 * i]
        }
        return sum > 0
    }
}