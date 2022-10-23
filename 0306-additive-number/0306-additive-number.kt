class Solution {
    private fun sum(left: Long, right: Long, current: String, target: String): Boolean {
        if (current.length == target.length && current == target) {
            return true
        }

        if (current.length > target.length || !target.startsWith(current)) {
            return false
        }

        return sum(right, left + right, "$current$right", target)
    }

    fun isAdditiveNumber(num: String): Boolean {
        if (num.length <= 2) {
            return false
        }
        for (leftCursor in 1 .. num.length / 3 + 1) {
            val left = num.substring(0 until leftCursor)
            if (left.startsWith("0") && left.length != 1) {
                continue
            }

            for (rightCursor in leftCursor + 1 ..  leftCursor + (num.length - leftCursor) / 2 + 1) {
                val right = num.substring(leftCursor until rightCursor)

                if (right.startsWith("0") && right.length != 1) {
                    continue
                }

                if (left.length + right.length >= num.length) {
                    return false
                }

                if (sum(left.toLong(), right.toLong(), left, num)) {
                    return true
                }
            }
        }

        return false
    }
}