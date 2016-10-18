public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] minHP = new int[m][n];

        minHP[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : 1 - dungeon[m - 1][n - 1];

        for(int i = m - 2; i >= 0; --i) {
        	if(dungeon[i][n - 1] >= minHP[i + 1][n - 1]) {
        		minHP[i][n - 1] = 1;
        	}
        	else {
        		minHP[i][n - 1] = minHP[i + 1][n - 1] - dungeon[i][n - 1];
        	}
        }

        for(int i = n - 2; i >= 0; --i) {
        	if(dungeon[m - 1][i] >= minHP[m - 1][i + 1]) {
        		minHP[m - 1][i] = 1;
        	}
        	else {
        		minHP[m - 1][i] = minHP[m - 1][i + 1] - dungeon[m - 1][i];
        	}
        }

        for(int i = m - 2; i >= 0; --i) {
        	for(int j = n - 2; j >= 0; --j) {
        		int min = Math.min(minHP[i + 1][j], minHP[i][j + 1]);
        		if(dungeon[i][j] >= min) {
        			minHP[i][j] = 1;
        		}
        		else {
        			minHP[i][j] = min - dungeon[i][j];
        		}
        	}
        }

 		return minHP[0][0];
    }
}