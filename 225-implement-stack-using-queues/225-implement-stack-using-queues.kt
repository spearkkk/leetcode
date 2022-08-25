class MyStack() {

    val holder = mutableListOf<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        holder.add(x)
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        return holder.removeAt(holder.size - 1)
    }

    /** Get the top element. */
    fun top(): Int {
        return holder.last()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return holder.isEmpty()
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */