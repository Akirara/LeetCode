/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); 
*/
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return binary(1, n);
    }

    private int binary(int low, int high) {
    	int mid = new Long(((long)low + high) / 2).intValue();
    	switch(guess(mid)) {
    		case 1:
    			return binary(mid + 1, high);
    		case -1:
    			return binary(low, mid - 1);
    		default:
    			return mid;
    	}
    }
}