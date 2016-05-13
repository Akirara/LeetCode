public class Solution {
    public int minPathSum(int[][] grid) {
    	int m = grid[0].length;
    	int n = grid.length;
    	int i = 0, j = 0;

    	int[][] sum = new int[n][m];

    	sum[0][0] = grid[0][0];
    	for(i = 1; i < m; i++)
    		sum[0][i] = sum[0][i - 1] + grid[0][i];
    	for(i = 1; i < n; i++)
    		sum[i][0] = sum[i - 1][0] + grid[i][0];

    	for(i = 1; i < n; i++) {
    		for(j = 1; j < m; j++) {
    			sum[i][j] = Math.min(sum[i][j - 1], sum[i - 1][j]) + grid[i][j];
    		}
    	}
    	return sum[n - 1][m - 1];
    }
}