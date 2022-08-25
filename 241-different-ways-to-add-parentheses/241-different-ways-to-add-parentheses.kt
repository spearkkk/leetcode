class Solution {
    fun diffWaysToCompute(expression: String): List<Int> {
        val result: MutableList<Int> = mutableListOf()

        for (i in expression.indices) {
            if (expression[i] != '+' && expression[i] != '-' && expression[i] != '*') {
                continue
            }

            val left = expression.slice((0 until i))
            val right = expression.slice((i + 1 until expression.length))
            val operator = expression[i]

            // 재귀로 함수를 통과하고 나올 때마다, 계산이 되지 않은 맨 앞과 뒤, 계산을 한 결과 중간의 값이 다 같이 나온다.
            val leftCandidates: List<Int> = diffWaysToCompute(left)
            val rightCandidates: List<Int> = diffWaysToCompute(right)

            for (leftCandidate in leftCandidates) {
                for (rightCandidate in rightCandidates) {
                    when (operator) {
                        '*' -> {
                            result.add(leftCandidate * rightCandidate)
                        }
                        '-' -> {
                            result.add(leftCandidate - rightCandidate)
                        }
                        else -> {
                            result.add(leftCandidate + rightCandidate)
                        }
                    }
                }
            }
        }

        // 맨 앞, 뒤에 대항 edge case
        if (result.size == 0) {
            result.add(expression.toInt())
        }

        return result
    }
}
