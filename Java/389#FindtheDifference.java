public class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0)
        	return t.charAt(0);
        char c = s.charAt(0);
        for(int i = 1; i < s.length(); ++i) {
        	c ^= s.charAt(i);
        }
        for(int i = 0; i < t.length(); ++i) {
        	c ^= t.charAt(i);
        }
        return c;
    }
}


public class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0)
        	return t.charAt(0);
        int[] count = new int[26];
        for(int i = 0; i < s.length(); ++i)
        	++count[s.charAt(i) - 'a'];
        for(int j = 0; j < t.length(); ++j) {
        	if(--count[t.charAt(j) - 'a'] == -1)
        		return t.charAt(j);
        }
    }
}