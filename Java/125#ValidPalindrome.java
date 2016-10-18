public class Solution {
    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        char cLow = 0;
        char cHigh = 0;
        while(low < high) {
        	while(low < high) {
        		cLow = s.charAt(low);
        		if((cLow <= 'z' && cLow >= 'a') || (cLow >= '0' && cLow <= '9')) {
        			break;
        		}
        		else if(cLow <= 'Z' && cLow >= 'A') {
        			cLow += 32;
        			break; 
        		}
        		else {
        			++low;
        		}
        	}
        	while(low < high) {
        		cHigh = s.charAt(high);
        		if((cHigh <= 'z' && cHigh >= 'a') || (cHigh >= '0' && cHigh <= '9')) {
        			break;
        		}
        		else if(cHigh <= 'Z' && cHigh >= 'A') {
        			cHigh += 32;
        			break; 
        		}
        		else {
        			--high;
        		}
        	}
        	if(low < high && cLow != cHigh) {
        		return false;
        	}
        	++low;
        	--high;
        }
        return true;
    }
}