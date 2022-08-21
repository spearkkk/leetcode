class Solution {
    private val valueToSymbol = mapOf(
        Pair(1000, "M"),
        Pair(900, "CM"),
        Pair(500, "D"),
        Pair(400, "CD"),
        Pair(100, "C"),
        Pair(90, "XC"),
        Pair(50, "L"),
        Pair(40, "XL"),
        Pair(10, "X"),
        Pair(9, "IX"),
        Pair(5, "V"),
        Pair(4, "IV"),
        Pair(1, "I")
    )

    fun intToRoman(num: Int): String {
        var x = num

        var result = ""
        for (entry in valueToSymbol.toSortedMap(reverseOrder())) {
            val currentValue = entry.key
            val currentSymbol = entry.value

            while (x >= currentValue) {
                x -= currentValue
                result += currentSymbol
            }
        }

        return result
    }
}
