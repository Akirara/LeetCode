public class Solution {
    public boolean isAdditiveNumber(String num) {
        for(int i = 1; i < num.length() / 2 + 1; ++i) {
        	if(num.charAt(0) == '0' && i > 1) {
        		return false;
        	}
        	for(int j = i + 1; j < num.length(); ++j) {
        		if(num.charAt(i) == '0' && j > i + 1) {
        			break;
        		}
        		Long l1 = Long.parseLong(num.substring(0, i));
        		Long l2 = Long.parseLong(num.substring(i, j));
        		int index = j;
        		int flag = 1;
        		while(index < num.length()) {
        			Long sum = l1 + l2;
        			String s = Long.toString(sum);
        			if(prefixMatch(s, num, index)) {
        				l1 = l2;
        				l2 = sum;
        				index += s.length();
        			}
        			else {
        				flag = 0;
        				break;
        			}
        		}
        		if(flag == 1) {
        			return true;
        		}
        	}
        }
        return false;
    }

    private boolean prefixMatch(String prefix, String s, int index) {
    	if(prefix.length() + index > s.length()) {
    		return false;
    	}
    	if(prefix.length() > 1 && s.charAt(index) == '0') {
    		return false;
    	}
    	for(int i = 0; i < prefix.length(); ++i) {
    		if(prefix.charAt(i) != s.charAt(index + i)) {
    			return false;
    		}
    	}
    	return true;
    }
}