class LRUCache(private val capacity: Int) {
    data class Node(val key: Int, val value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val cache = mutableMapOf<Int, Node>()
    private val head: Node = Node(-1, -1)
    private val tail: Node = Node(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        if (cache.containsKey(key)) {
            val currentNode = cache[key]!!
            remove(currentNode)
            addTail(currentNode)
            return currentNode.value
        }
        return -1

    }

    fun put(key: Int, value: Int) {
        if (cache.containsKey(key)) {
            remove(cache[key]!!)
        }

        val newNode = Node(key, value)
        addTail(newNode)
        cache[key] = newNode

        if (cache.size > capacity) {
            val lastUsedNode = head.next!!
            remove(lastUsedNode)
            cache.remove(lastUsedNode.key)
        }

    }

    private fun remove(node: Node) {
        val prevNode = node.prev!!
        val nextNode = node.next!!

        prevNode.next = nextNode
        nextNode.prev = prevNode
    }

    private fun addTail(node: Node) {
        val lastNode = tail.prev!!
        lastNode.next = node
        node.prev = lastNode

        node.next = tail
        tail.prev = node
    }

}