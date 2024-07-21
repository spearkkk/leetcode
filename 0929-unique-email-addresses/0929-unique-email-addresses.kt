class Solution {
    fun numUniqueEmails(emails: Array<String>): Int {
        val at = '@'
        val plus = '+'
        val dot = '.'

        val holder = mutableSetOf<String>()
        for (email in emails) {
            var cursor = 0
            var localName = ""

            while (true) {
                if (email[cursor] == at) {
                    holder.add(localName + email.substring(cursor))
                    break
                }

                if (email[cursor] == dot) {
                    cursor += 1
                    continue
                }

                if (email[cursor] == plus) {
                    cursor = email.indexOf(at, cursor)
                    continue
                }

                localName += email[cursor]
                cursor += 1
            }
        }

//        println(holder.joinToString(" "))
        return holder.size
    }
}