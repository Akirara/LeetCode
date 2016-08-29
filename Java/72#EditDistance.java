public class Solution {
    public int minDistance(String word1, String word2) {
    	int m = word1.length();
    	int n = word2.length();
    	if(m == 0 || n == 0) {
    		return m + n;
    	}
    	int[][] table = new int[m + 1][n + 1];
    	for(int i = 0; i <= m; ++i) {
    		table[i][0] = i;
    	}
    	for(int i = 0; i <= n; ++i) {
    		table[0][i] = i;
    	}
    	for(int i = 1; i <= m; ++i) {
    		for(int j = 1; j <= n; ++j) {
    			int tmp = word1.charAt(i - 1) == word2.charAt(j - 1) ? table[i - 1][j - 1] : table[i - 1][j - 1] + 1;
    			table[i][j] = Math.min(table[i][j - 1], table[i - 1][j]);
    			table[i][j] = Math.min(table[i][j] + 1, tmp);
    		}
    	}
    	return table[m][n];
    }
}