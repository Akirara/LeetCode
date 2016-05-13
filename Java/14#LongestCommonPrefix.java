public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	String ret = new String();

    	if(strs.length == 0)
    		return ret;
    	
    	int len = strs[0].length();
    	for(int i = 1; i < strs.length; i++) {
    		len = Math.min(len, strs[i].length());
    	}

    	for(int i = 0; i < len; i++) {
    		char c = strs[0].charAt(i);
    		for(int j = 1; j < strs.length; j++) {
    			if(strs[j].charAt(i) != c) {
    				ret = strs[0].substring(0, i);
    				return ret;
    			}
    		}
    	}
        
        ret = strs[0].substring(0, len);
        return ret;
    }
}