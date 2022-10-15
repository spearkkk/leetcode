
class MyQueue() {
    private val left = java.util.Stack<Int>()
    private val right = java.util.Stack<Int>()

    fun push(x: Int) {
        left.push(x)
    }

    fun pop(): Int {
        while (left.isNotEmpty()) {
            right.push(left.pop())
        }
        val tmp = right.pop()
        while(right.isNotEmpty()) {
            left.push(right.pop())
        }
        return tmp
    }

    fun peek(): Int {
        while (left.isNotEmpty()) {
            right.push(left.pop())
        }
        val tmp = right.peek()
        while(right.isNotEmpty()) {
            left.push(right.pop())
        }
        return tmp
    }

    fun empty(): Boolean {
        return left.isEmpty()
    }

}