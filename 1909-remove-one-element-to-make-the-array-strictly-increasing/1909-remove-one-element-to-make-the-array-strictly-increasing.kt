class Solution {
  fun check(nums: IntArray, skip: Int): Boolean {
    var last = -100001
    for (cursor in 0 until nums.size) {
      if (cursor == skip) {
        continue
      }
      
      if (last >= nums[cursor]) {
        return false
      }
      last = nums[cursor]
    }
    return true
  }
  fun canBeIncreasing(nums: IntArray): Boolean {
    for (cursor in nums.indices) {
      if (check(nums, cursor)) {
        return true
      }
    }
    return false
  }
}