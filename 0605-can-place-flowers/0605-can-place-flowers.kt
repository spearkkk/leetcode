class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var cursor = 0

        fun paintedIfPossible(): Boolean {
            while (true) {
                if (cursor >= flowerbed.size) {
                    break
                }

                if (flowerbed[cursor] == 1) {
                    cursor += 1
                    continue
                }

                if (cursor + 1 < flowerbed.size && flowerbed[cursor + 1] == 1) {
                    cursor += 1
                    continue
                }
                if (cursor - 1 >= 0 && flowerbed[cursor - 1] == 1) {
                    cursor += 1
                    continue
                }

                flowerbed[cursor] = 1
                cursor += 1
                return true
            }

            return false
        }

        var cnt = n

        while (cnt != 0) {
            if (paintedIfPossible()) {
                cnt -= 1
                continue
            }
            return false
        }

        return true
    }
}