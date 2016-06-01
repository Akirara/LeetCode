public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0)
        	return 0;
        int n = obstacleGrid[0].length;
        if(n == 0)
        	return 0;
        if(obstacleGrid[0][0] == 1)
        	return 0;
        int[][] count = new int[m][n];
        count[0][0] = 1;
        for(int i = 1; i < n; i++) {
        	if(obstacleGrid[0][i] == 1) {
        		count[0][i] = 0;
        	}
        	else {
        		count[0][i] = count[0][i - 1];
        	}
        }
        for(int i = 1; i < m; i++) {
        	if(obstacleGrid[i][0] == 1) {
        		count[i][0] = 0;
        	}
        	else {
        		count[i][0] = count[i - 1][0];
        	}
        }
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			count[i][j] = 0;
        		}
        		else {
        			count[i][j] = count[i - 1][j] + count[i][j - 1];
        		}
        	}
        }
        return count[m - 1][n - 1];
    }
}