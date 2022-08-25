class Solution {
   fun fizzBuzz(n: Int): List<String> {
        val result = mutableListOf<String>()

        for (i in 1 .. n) {
            var tmp = ""
            if (i % 3 == 0) tmp += "Fizz"
            if (i % 5 == 0) tmp += "Buzz"

            result.add(tmp.ifBlank { i.toString() })
        }
        return result
    }
}