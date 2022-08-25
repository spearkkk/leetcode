class Solution {
    fun findComplement(num: Int): Int {

        var cap = 1L

        /// num이 101이면 1000까지의 수를 만든다.
        while (cap <= num) {
            cap = cap.shl(1)
        }
        /// cap - 1로 하여 1000을 111로 만든다.
        /// 이후 xor 연산으로 뒤집는다.
        return (cap - 1).toInt().xor(num)
    }
}