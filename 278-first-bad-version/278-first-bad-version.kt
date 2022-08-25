/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    
    override fun firstBadVersion(n: Int) : Int {
        var base = 1
        var end = n
        
        while (base < end) {
            val center = base + (end - base) / 2
            if (!isBadVersion(center)) {
                base = center + 1
            } else {
                end = center
            }
        }
        return base
	}
}