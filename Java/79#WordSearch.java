public class Solution {
    public boolean exist(char[][] board, String word) {
    	int m = board.length;
    	int n = board[0].length;
    	int len = word.length();
    	int[][] flag = new int[m][n];
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(board[i][j] == word.charAt(0)) {
    				if(dfs(board, flag, m, n, i, j, 0, len, word))
    					return true;
    			}
    		}
    	}
    	return false;
    }

    public boolean dfs(char[][] board, int[][] flag, int m, int n, int i, int j, int k, int len, String word) {
    	if(k == len)
    		return true;
    	if(i < 0 || i == m || j < 0 || j == n || board[i][j] != word.charAt(k) || flag[i][j] == 1)
    		return false;
    	flag[i][j] = 1;
    	boolean res = dfs(board, flag, m, n, i - 1, j, k + 1, len, word) ||
  					  dfs(board, flag, m, n, i + 1, j, k + 1, len, word) ||
  					  dfs(board, flag, m, n, i, j - 1, k + 1, len, word) ||
  					  dfs(board, flag, m, n, i, j + 1, k + 1, len, word);
  		flag[i][j] = 0;
  		return res;
    }
}