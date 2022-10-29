class NestedIterator(nestedList: List<NestedInteger>) {
    private val holder: List<Int> = flatten(nestedList)
    private var cursor = 0

    private fun flatten(nestedList: List<NestedInteger>): List<Int> {
        val holder = mutableListOf<Int>()
        for (list in nestedList) {
            if (list.isInteger()) {
                holder.add(list.getInteger()!!)
                continue
            }
            holder.addAll(flatten(list.getList()!!))
        }
        

        return holder
    }

    fun next(): Int {
        val tmp = holder[cursor]
        cursor += 1
        return tmp
    }
    
    fun hasNext(): Boolean {
        return holder.size != cursor
    }
}