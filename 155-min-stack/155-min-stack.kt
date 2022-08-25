import java.util.HashMap

class MinStack {
    /** initialize your data structure here. */

    var capability = 10000
    var currentSize = 0

    var holder: Array<Int?> = Array(capability) { 0 }
    val minimumHolder = HashMap<Int, Int>()

    fun push(x: Int) {
        if (currentSize >= capability) {
            holder = holder.copyOf(currentSize + capability)
        }
        holder[currentSize] = x
        currentSize += 1

        val count = minimumHolder.getOrDefault(x, 0) + 1
        minimumHolder[x] = count
    }

    fun pop() {
        if (currentSize == 0) {
            return
        }

        val tmp = holder[currentSize - 1]!!
        if (minimumHolder.containsKey(tmp)) {
            minimumHolder[tmp] = minimumHolder[tmp]!! - 1
        }

        holder[currentSize - 1] = null
        currentSize -= 1
    }

    fun top(): Int {
        return holder[currentSize - 1]!!
    }

    fun getMin(): Int {
        // return minimumHolder.filter { entry -> entry.value > 0 }.minOf { entry -> entry.key }
       return minimumHolder.filter { entry -> entry.value > 0 }.minBy { entry -> entry.key }!!.key
    }
}