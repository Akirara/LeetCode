public class Solution {
    public boolean isScramble(String s1, String s2) {
    	int len = s1.length();
    	boolean[][][] isSubScramble = new boolean[len][len][len];
    	for(int i = 0; i < len; ++i) {
    		for(int j = 0; j < len; ++j) {
    			if(s1.charAt(i) == s2.charAt(j)) {
    				isSubScramble[i][j][0] = true;
    			}
    		}
    	}
    	for(int k = 1; k < len; ++k) {
    		for(int i = 0; i + k < len; ++i) {
    			for(int j = 0; j + k < len; ++j) {
    				for(int index = 0; index < k; ++index) {
    					if((isSubScramble[i][j][index] && isSubScramble[i + index + 1][j + index + 1][k - index - 1])
    						|| (isSubScramble[i][j + k - index][index] && isSubScramble[i +index + 1][j][k - index - 1])) {
    							isSubScramble[i][j][k] = true;
    							break;
    						}
    				}
    			}
    		}
    	}
    	return isSubScramble[0][0][len - 1];
    }
}