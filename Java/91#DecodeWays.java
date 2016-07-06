public class Solution {
    public int numDecodings(String s) {
    	if(s.length() == 0)
    		return 0;
        return count(s, s.length() - 1);
    }

    public int count(String s, int pos) {
    	if(pos < 0)
    		return 1;
    	if(pos == 0) {
    		if(s.charAt(0) != '0')
    			return 1;
    		else
    			return 0;
    	}
    	if(s.charAt(pos) == '0')
    		return count(s, pos - 2);
    	if(s.charAt(pos - 1) == '1' || (s.charAt(pos) < '7' && s.charAt(pos - 1) == '2'))
    		return count(s, pos - 1) + count(s, pos - 2);
    	return count(s, pos - 1);
    }
}