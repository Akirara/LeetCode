public class Solution {
    public boolean isPowerOfTwo(int n) {
    	if(n < 1)
    		return false;
    	while(true) {
    		if(n == 1)
    			return true;
    		if(n % 2 == 1)
    			return false;
    		n /= 2;
    	}
    }
}