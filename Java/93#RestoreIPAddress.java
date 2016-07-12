public class Solution {
    public List<String> restoreIpAddresses(String s) {
    	List<String> ret = new ArrayList();
    	int len = s.length();
    	if(len < 4 || len > 12)
    		return ret;
    	for(int i = 1; i < 4; i++) {
    		String a = s.substring(0, i);
    		String rest = s.substring(i, len);
    		if(!stringCheck(a) || rest.length() < 3)
    			return ret;
    		for(int j = i + 1; j < i + 4 && j < len; j++) {
    			String b = s.substring(i, j);
    			rest = s.substring(j, len);
    			if(!stringCheck(b) || rest.length() < 2)
    				continue;
    			for(int k = j + 1; k < j + 4 && k < len; k++) {
    				String c = s.substring(j, k);
    				rest = s.substring(k, len);
    				if(!stringCheck(c) || rest.length() < 1)
    					continue;
    				if(stringCheck(rest))
    					ret.add(a + "." + b + "." + c + "." + rest);
    			}
    		}
    	}
    	return ret;
    }

    public boolean stringCheck(String s) {
    	int len = s.length();
    	if(len < 1 || len > 3)
    		return false;
    	if(len == 1)
    		return true;
    	if(len == 2)
    		return s.compareTo("10") < 0 ? false : true;
    	if(s.compareTo("100") < 0 || s.compareTo("255") > 0)
    		return false;
    	return true;
    }
}