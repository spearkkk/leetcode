class Logger() {
    val messageToTimestamp = mutableMapOf<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if (messageToTimestamp.containsKey(message)) {
            if (messageToTimestamp[message]!! + 10 <= timestamp) {
                messageToTimestamp[message] = timestamp
                return true
            }
            return false
        }
        messageToTimestamp[message] = timestamp
        return true
    }

}