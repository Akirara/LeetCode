public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] count = new int[m][n];

        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		if(board[i][j] == 1) {
        			increase(count, m, n, i - 1, j - 1);
        			increase(count, m, n, i - 1, j);
        			increase(count, m, n, i - 1, j + 1);
        			increase(count, m, n, i, j + 1);
        			increase(count, m, n, i + 1, j + 1);
        			increase(count, m, n, i + 1, j);
        			increase(count, m, n, i + 1, j - 1);
        			increase(count, m, n, i, j - 1);
        		}
        	}
        }

        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		if(board[i][j] == 0 && count[i][j] == 3) {
        			board[i][j] = 1;
        		}
        		else if(board[i][j] == 1) {
        			if(count[i][j] < 2 || count[i][j] > 3) {
        				board[i][j] = 0;
        			}
        		}
        	}
        }
    }

    public void increase(int[][] count, int m, int n, int i, int j) {
    	if(i < 0 || i >= m || j < 0 || j >= n) {
    		return;
    	}
    	++count[i][j];
    }
}