/** 
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

class Solution:GuessGame() {
    override fun guessNumber(n:Int):Int {
        var low = 1
        var high = n
        
        while (low <= high) {
            val mid = low + (high - low) / 2
            val guessed = guess(mid)
            
            if (guessed == 0) {
                return  mid
            }
            
            if (guessed < 0)  {
                high = mid - 1
                continue
            }
            low = mid + 1
        }
        return -1
    }
}