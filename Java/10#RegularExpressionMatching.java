public class Solution {
    public boolean isMatch(String s, String p) {
    	int sLen = s.length();
 		int pLen = p.length();
 		char[] sChar = s.toCharArray();
 		char[] pChar = p.toCharArray();
    	boolean[][] dp = new boolean[sLen + 1][pLen + 1];
    	dp[0][0] = true;
    	for(int i = 2; i <= pLen; ++i) {
    		if(pChar[i - 1] == '*' && dp[0][i - 2]) {
    			dp[0][i] = true;
    		}
    	}
    	for(int i = 1; i <= sLen; ++i) {
    		for(int j = 1; j <= pLen; ++j) {
    			if(pChar[j - 1] == '*') {
    				dp[i][j] = (dp[i - 1][j] && (pChar[j - 2] == '.' || sChar[i - 1] == pChar[j - 2]))
    							|| dp[i][j - 1] || dp[i][j - 2];
    			}
    			else if(pChar[j - 1] == '.' || sChar[i - 1] == pChar[j - 1]){
    				dp[i][j] = dp[i - 1][j - 1];
    			}
    		}
    	}
    	return dp[sLen][pLen];
    }
}