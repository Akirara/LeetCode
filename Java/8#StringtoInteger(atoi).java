public class Solution {
    public int myAtoi(String str) {
    	if(str.length() < 1)
    		return 0;
    	int index = 0;
    	int ret = 0;
    	int len = str.length();
    	boolean isNegative = false;
    	while(str.charAt(index) == ' ' && index < len)
    		index++;

    	if(str.charAt(index) == '-') {
    		isNegative = true;
    		index++; 
    	}
    	else if(str.charAt(index) == '+') {
    		index++; 
    	}
    	
    	if(index == len) {
    		return 0;
    	}
    	
    	char c = str.charAt(index);
    	if(c < '0' || c > '9') {
    		return 0;
    	}

    	while(c >= '0' && c <= '9') {
    		if(ret > Integer.MAX_VALUE / 10) {
    			return (isNegative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    		}
    		ret = ret * 10;
    		if(!isNegative && ret > Integer.MAX_VALUE - c + '0') {
    			return Integer.MAX_VALUE;
    		}
    		else if(isNegative && ret - 1 > Integer.MAX_VALUE - c + '0') {
    			return Integer.MIN_VALUE;
    		}
    		else {
    			ret = ret + c - '0';
    			if(++index < len) {
      				c = str.charAt(index);	
				}
				else {
					break;
				}
    		}
    	}

    	if(isNegative)
    		ret = -ret;

    	return ret;
    }
}