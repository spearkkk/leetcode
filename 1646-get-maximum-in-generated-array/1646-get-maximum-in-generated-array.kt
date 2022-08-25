class Solution {
    fun getMaximumGenerated(n: Int): Int {
        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        
        val nums = IntArray(100 + 1) { 0 }

        nums[1] = 1

        var result = 0
        
        for (i in 2 .. n) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2]
            } else {
                val tmp = i / 2
                nums[i] = nums[tmp] + nums[tmp + 1]
            }
            
            if (result < nums[i]) {
                result = nums[i]
            }
        }

        return result
    }
}