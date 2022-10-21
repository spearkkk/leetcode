class PeekingIterator(val it: Iterator<Int>): Iterator<Int> {
    var valid = false
    var value = -1

    private fun tryload(){
        if(valid) return

        if(it.hasNext()){
            valid = true
            value = it.next()
        }
    }

    fun peek(): Int {
        tryload()
        return value
    }

    override fun next(): Int {
        tryload()
        valid = false
        return value
    }

    override fun hasNext(): Boolean {
        return valid || it.hasNext()
    }
}