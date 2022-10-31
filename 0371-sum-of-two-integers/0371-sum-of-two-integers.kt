class Solution {
    fun getSum(a: Int, b: Int): Int {
        var copiedA = a
        var copiedB = b
        while (copiedB != 0) {
            val carry = copiedA.and(copiedB)
            copiedA = copiedA.xor(copiedB)
            copiedB = carry.shl(1)
        }
        return copiedA
    }
}