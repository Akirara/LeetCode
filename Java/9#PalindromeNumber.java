/*
*	used no extra space
*/

public class Solution {
    public boolean isPalindrome(int x) {
    	if(x < 0)
    		return false;

    	int count = 0;
    	long times = 10;

    	while(x > times) {
    		times *= 10;
    		count++;
    	}

    	int high = 1;
    	for(int i = 0; i < count; i++)
    		high *= 10;

    	int low = 10;

    	while(x / high == x % low) {
    		if(high <= low || high == 100)
    			return true;

    		x = (x % high) / 10;
    		high /= 100;
     	}

     	return false;
    }
}

/*
*	processed as String
*/
public class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        int low = 0, high = s.length() - 1;

        while(s.charAt(low) == s.charAt(high)) {
        	if(high - low <= 1) {
        		return true;
        	}
        	low++;
        	high--;
        }

        return false;
    }
}