public class Solution {
    public int lengthOfLastWord(String s) {
        String s1 = s.trim();
        int len = s1.length();
        int ret = 0;
        if(len == 0)
        	return ret;
        for(int i = len - 1; i >= 0; i--, ret++) {
        	if(s1.charAt(i) == ' ')
        		break;
        }
        return ret;
    }
}