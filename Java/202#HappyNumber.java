public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet();
        int tmp = 1;
        int a = 0;
        while(!hs.contains(tmp)) {
        	hs.add(tmp);
        	tmp = 0;
        	while(n > 0) {
        		a = n % 10;
        		tmp += a * a;
        		n /= 10;
        	}
        	if(tmp == 1)
        		return true;
        	n = tmp;
        }
        return false;
    }
}


public class Solution {
    public boolean isHappy(int n) {
		int res = 0;
		int a = 0;
    	while(true) {
    		res = 0;
    		for(; n > 0; n /= 10) {
    			a = n % 10;
    			res += a * a;
    		}
    		n = res;
    		if(n == 1)
    			return true;
    		else if(n == 4)
    			return false;
    	}
    }
}