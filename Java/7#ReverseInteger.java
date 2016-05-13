/*
*	processed as string
*/
public class Solution {
    public int reverse(int x) {
    	String s = String.valueOf(x);
    	int flag = 0;
    	StringBuilder sb = new StringBuilder(s);
    	s = sb.reverse().toString();
    	
    	if(s.endsWith("-")) {
    		flag = 1;
    		s = s.substring(0, s.length() - 1);
    	}

    	double d = Double.valueOf(s).doubleValue();
    	if((flag == 0 && d > 2147483647.0) || (flag == 1 && d > 2147483648.0))
    		return 0;

    	int ret = (flag == 0)?(int)d:-(int)d;
    	return ret;
    }
}

/*
*	
*/
public class Solution {
    public int reverse(int x) {
    	int result = 0;
    	boolean isPositive = x > 0 ? true : false;
    	if(!isPositive)
    		x = -x;
    	while(x > 0) {
    		if(result > Integer.MAX_VALUE / 10)
    			return 0;
    		result = result * 10 + x % 10;
    		x = x / 10; 
    	}
    	
    	if(!isPositive)
    		result = - result;

    	return result;
    }
}